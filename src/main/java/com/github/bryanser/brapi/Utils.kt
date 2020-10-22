package com.github.bryanser.brapi

import com.comphenix.protocol.utility.MinecraftReflection
import net.md_5.bungee.api.chat.HoverEvent
import net.md_5.bungee.api.chat.TextComponent
import net.milkbowl.vault.economy.Economy
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Server
import org.bukkit.block.Block
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.Plugin
import org.bukkit.util.Vector
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.lang.reflect.Method
import java.util.*
import java.util.logging.Level


typealias Projector = (Double, Double) -> Location

object Utils {
    @JvmField
    val economy: Economy?

    init {
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            economy = null
        } else {
            val rsp = Bukkit.getServicesManager().getRegistration(Economy::class.java)
            if (rsp == null) {
                economy = null
            } else {
                economy = rsp.provider ?: null
            }
        }
    }

    @JvmStatic
    fun createItemHoverEvent(item: ItemStack): HoverEvent {
        return HoverEvent(HoverEvent.Action.SHOW_ITEM, arrayOf(TextComponent(convertItemStackToJson(item))))
    }

    fun convertItemStackToJson(itemStack: ItemStack): String {
        val craftItemStackClazz = MinecraftReflection.getCraftItemStackClass()
        val asNMSCopyMethod = craftItemStackClazz.getMethod("asNMSCopy", ItemStack::class.java)
        val nmsItemStackClazz = MinecraftReflection.getMinecraftClass("ItemStack")
        val nbtTagCompoundClazz = MinecraftReflection.getMinecraftClass("NBTTagCompound")
        val saveNmsItemStackMethod = nmsItemStackClazz.getMethod("save", nbtTagCompoundClazz)
        val nmsNbtTagCompoundObj: Any
        val nmsItemStackObj: Any
        val itemAsJsonObject: Any

        try {
            nmsNbtTagCompoundObj = nbtTagCompoundClazz.newInstance()
            nmsItemStackObj = asNMSCopyMethod.invoke(null, itemStack)
            itemAsJsonObject = saveNmsItemStackMethod.invoke(nmsItemStackObj, nmsNbtTagCompoundObj)
        } catch (t: Throwable) {
            Bukkit.getLogger().log(Level.SEVERE, "failed to serialize itemstack to nms item", t)
            return "{}"
        }
        return itemAsJsonObject.toString()

    }

    private var getOnlinePlayers_onlinePlayerMethod: Method? = null

    /**
     * 合理的获取在线玩家~
     *
     * @return
     */
    @JvmStatic
    fun getOnlinePlayers(): Collection<Player> {
        try {
            if (getOnlinePlayers_onlinePlayerMethod == null) {
                getOnlinePlayers_onlinePlayerMethod = Server::class.java!!.getMethod("getOnlinePlayers")
            }
            return if (Collection::class.java.isAssignableFrom(getOnlinePlayers_onlinePlayerMethod!!.getReturnType())) {
                getOnlinePlayers_onlinePlayerMethod!!.invoke(Bukkit.getServer()) as Collection<Player>
            } else {
                Arrays.asList(*(getOnlinePlayers_onlinePlayerMethod!!.invoke(Bukkit.getServer()) as Array<Player>))
            }
        } catch (ex: Exception) {
        }

        return ArrayList()
    }

    /**
     * 数据插件jar里的文件
     *
     * @param p 插件
     * @param res 资源文件名 如config.yml
     * @param fold 目标文件夹 若为null则默认插件配置文件夹
     * @throws IOException
     */
    @Throws(IOException::class)
    @JvmStatic
    fun saveResource(p: Plugin, res: String, fold: File? = null) {
        var fold = fold
        p.getResource(res).use { data ->
            if (data == null) {
                return
            }
            if (fold == null) {
                fold = p.getDataFolder()
                if (!fold!!.exists()) {
                    fold!!.mkdirs()
                }
            }
            if (!fold!!.exists()) {
                fold!!.mkdirs()
            }
            val f = File(fold, res)

            if (!f.exists()) {
                f.createNewFile()
            }
            FileOutputStream(f).use { fos ->
                while (true) {
                    val i = data!!.read()
                    if (i == -1) {
                        break
                    }
                    fos.write(i)
                }
            }
        }
    }

    /**
     * 安全的添加物品到玩家背包,如果玩家背包满了. 会将物品丢弃到地上
     *
     * @param p 玩家
     * @param item 物品
     * @param whenInvFull 当背包满了的时候执行的操作 默认丢弃到附近:[safeDropItem]
     */
    @JvmStatic
    fun safeGiveItem(p: Player, item: ItemStack?, whenInvFull: (Player, ItemStack) -> Unit = ::safeDropItem) {
        val item = item?.clone() ?: return
        if (p.inventory.firstEmpty() == -1 && item.maxStackSize == 1) { // 背包满了
            whenInvFull(p, item)
            return
        }
        var allowCount = 0
        for (sInvItem in p.inventory.contents) {
            if (sInvItem != null && sInvItem.type != Material.AIR) {
                if (sInvItem.isSimilar(item)) {
                    allowCount += sInvItem.maxStackSize - sInvItem.amount
                }
            } else {
                allowCount += item.maxStackSize
            }
            if (allowCount >= item.amount) {
                break
            }
        }
        if (allowCount < item.amount) {
            val dropItems = item.clone()
            dropItems.amount = item.amount - allowCount
            item.amount = allowCount
            whenInvFull(p, dropItems)
        }
        if (item.maxStackSize != 0) {
            for (i in 0 until item.amount / item.maxStackSize) {
                val giveItem = item.clone()
                giveItem.amount = giveItem.maxStackSize
                p.inventory.addItem(giveItem)
            }
        }
        if (item.maxStackSize > 1) {
            val leftItemCount = item.amount % item.maxStackSize
            if (leftItemCount != 0) {
                val giveItem = item.clone()
                giveItem.amount = leftItemCount
                p.inventory.addItem(giveItem)
            }
        }
        p.updateInventory()
    }

    /**
     * 将物品掉落在玩家周围
     *
     * @param p 玩家
     * @param item 物品
     */
    @JvmStatic
    fun safeDropItem(p: Player, item: ItemStack?) {
        if (item == null) {
            return
        }
        if (item.amount > 64) {
            do {
                val s = item.clone()
                s.amount = 64
                p.world.dropItem(p.location, s)
                item.amount = item.amount - 64
            } while (item.amount <= 64)
            p.world.dropItem(p.location, item)
            return
        }
        p.world.dropItem(p.location, item)
    }

    /**
     * 读取一个指定格式的物品
     * ### 格式: ID 数量 损伤值
     * #### 可选: Name:名字 Lore:Lore Color:RED(用于染料羊毛) 或 Color:RGB(用于皮革)
     * #### Ench:附魔Id-附魔等级<p>
     * @param s 参数
     * @return 物品
     */
    @JvmStatic
    fun readItemStack(s: String): ItemStack {
        return Br.API.Utils.readItemStack(s)
    }


    /**
     * 创建一个2D→3D的投影器
     *
     * @param loc 3D坐标原点
     * @param n 法向量
     * @return 投影器
     */
    @JvmStatic
    fun create2DProjector(loc: Location, n: Vector): Projector {
        val t = n.clone()
        t.y = t.y + 1
        val n1 = n.clone().crossProduct(t).normalize()
        val n2 = n1.clone().crossProduct(n).normalize()
        return { x, y ->
            val r = n1.clone().multiply(x).add(n2.clone().multiply(y))
            loc.clone().add(r)
        }
    }

    /**
     * 创建一个3D→3D的投影器
     *
     * @param loc 3D坐标原点
     * @param n 法向量
     * @return 投影器
     */
    @JvmStatic
    fun create3DProjector(loc: Location, n: Vector): (x: Double, y: Double, z: Double) -> Location {
        val t = n.clone()
        t.y = t.y + 1
        val n1 = n.clone().crossProduct(t).normalize()
        val n2 = n1.clone().crossProduct(n).normalize()
        val n3 = n.clone().normalize()
        return { x, y, z ->
            val r = n1.clone().multiply(x).add(n2.clone().multiply(z)).add(n3.clone().multiply(y))
            loc.clone().add(r)
        }
    }

    /**
     * 获得一个向量的水平朝右的向量
     * *若向量为垂直于xoz平面的向量 将无法正确返回*
     *
     * @param look 向量
     * @return 朝右的向量
     */
    @JvmStatic
    fun getRight(look: Vector): Vector {
        var look = look
        look = look.clone()
        val left = look.crossProduct(Vector(0, 1, 0))
        return left.normalize()
    }

    /**
     * 获得一个向量水平朝左的向量
     * *若向量为垂直与xoz平面的向量 将无法正确返回*
     *
     * @param look 向量
     * @return 朝左的向量
     */
    @JvmStatic
    fun getLeft(look: Vector): Vector {
        return getRight(look).multiply(-1)
    }

    /**
     * 将向量转换为Location里使用的yaw与pitch
     *
     * @param v 向量
     * @return [0]为yaw [1]为pitch
     */
    @JvmStatic
    fun toYawAndPitch(v: Vector): FloatArray {
        val pitch = Math.acos(-v.y)
        return floatArrayOf(Math.toDegrees(Math.asin(-v.x / Math.acos(pitch))).toFloat(), Math.toDegrees(pitch).toFloat())
    }

    /**
     * 获得一个实体指针指向的实体
     *
     * @param e 实体
     * @param maxlength 最大搜索距离
     * @param ρ 搜索精度(越大越好) 默认50
     * @param exit 停止搜索的条件, 默认为遇到非空气
     * @return
     */
    @JvmStatic
    @JvmOverloads
    fun getLookAtEntity(
            e: LivingEntity,
            maxlength: Double,
            ρ: Int = 50,
            exit: ((Block) -> Boolean) = { it.type != Material.AIR }
    ): LivingEntity? {
        return getLineEntitys(
                e.eyeLocation,
                e.location.direction,
                maxlength,
                ρ,
                exit
        ).filter { it !== e }.firstOrNull { it is LivingEntity } as? LivingEntity?
    }

    /**
     * 获得一条直线上的实体们
     *
     * @param loc 起点
     * @param vector 方向
     * @param maxlength 最大搜索半径
     * @param ρ 搜索精度(越大越好) 默认50
     * @param exit 停止搜索的条件, 默认为遇到非空气
     * @return
     */
    @JvmStatic
    @JvmOverloads
    fun getLineEntitys(
            loc: Location,
            vector: Vector? = null,
            maxlength: Double = 20.0,
            ρ: Int = 20,
            exit: ((Block) -> Boolean) = { it.type != Material.AIR }
    ): List<Entity> {
        val v = (if (vector == null) loc.direction else vector).normalize()
        val l = maxlength / ρ
        val list = mutableListOf<Entity>()
        var length = l
        var searchR = l / 2
        val added = mutableSetOf<Int>()
        while (length < maxlength) {
            val vd = v.clone().multiply(length)
            val nloc = loc.clone().add(vd)
            if (exit(nloc.block)) {
                break
            }
            for (e in nloc.world.getNearbyEntities(nloc, searchR, 0.25, searchR)) {
                if (!added.contains(e.entityId)) {
                    list += e
                    added += e.entityId
                }
            }
            length += l
        }
        return list
    }

    @JvmField
    val defaultMatcher: (ItemMatcher, ItemMatcher) -> Boolean = { i1, i2 ->
        i1.id == i2.id && i1.durability == i2.durability && Bukkit.getItemFactory().equals(i1.meta, i2.meta)
    }

    @JvmStatic
    @JvmOverloads
    fun hasEnoughItems(p: Player, items: Iterable<ItemStack?>, matcher: (ItemMatcher, ItemMatcher) -> Boolean = defaultMatcher): Boolean {
        val map: MutableMap<ItemMatcher, Int> = HashMap()
        items.forEach { item: ItemStack? ->
            if (item == null) {
                return@forEach
            }
            val i = ItemMatcher(item, matcher)
            if (map.containsKey(i)) {
                map[i] = map[i]!! + item.amount
            } else {
                map[i] = item.amount
            }
        }
        for (`is` in p.inventory.contents) {
            if (`is` == null || `is`.amount == 0 || `is`.type == Material.AIR) {
                continue
            }
            for (item in map.keys) {
                if (item.isSame(`is`)) {
                    map[item] = map[item]!! - `is`.amount
                    break
                }
            }
        }
        return map.values.stream().noneMatch { a: Int -> a > 0 }
    }

    @JvmStatic
    @JvmOverloads
    fun removeItem(p: Player, items: Iterable<ItemStack?>, matcher: (ItemMatcher, ItemMatcher) -> Boolean = defaultMatcher) {
        val map: MutableMap<ItemMatcher, Int> = HashMap()
        items.forEach { item: ItemStack? ->
            if (item == null) {
                return@forEach
            }
            val i = ItemMatcher(item, matcher)
            if (map.containsKey(i)) {
                map[i] = map[i]!! + item.amount
            } else {
                map[i] = item.amount
            }
        }
        A@ for (e in map.entries) {
            val cl = e.key
            var amount = e.value
            for (i in 0 until p.inventory.size) {
                val item = p.inventory.getItem(i)
                if (amount <= 0) {
                    continue@A
                }
                if (item == null) {
                    continue
                }
                if (cl.isSame(item)) {
                    if (amount - item.amount < 0) {
                        item.amount = item.amount - amount
                        p.inventory.setItem(i, item)
                        continue@A
                    }
                    if (amount == item.amount) {
                        p.inventory.setItem(i, null)
                        continue@A
                    }
                    if (amount > item.amount) {
                        amount -= item.amount
                        p.inventory.setItem(i, null)
                    }
                }
            }
        }
    }
}

