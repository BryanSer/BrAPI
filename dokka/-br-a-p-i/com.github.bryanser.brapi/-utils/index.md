[BrAPI](../../index.md) / [com.github.bryanser.brapi](../index.md) / [Utils](./index.md)

# Utils

`object Utils` [(source)](https://github.com/BryanSer/BrAPI/raw/ver-kotlin/src/main/kotlin/com/github/bryanser/brapi/Utils.kt#L24)

### Properties

| Name | Summary |
|---|---|
| [economy](economy.md) | `val economy: Economy?` |

### Functions

| Name | Summary |
|---|---|
| [create2DProjector](create2-d-projector.md) | `fun create2DProjector(loc: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`, n: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`): `[`Projector`](../-projector.md)<br>创建一个2D→3D的投影器 |
| [getLeft](get-left.md) | `fun getLeft(look: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`): `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)<br>获得一个向量的水平朝左的向量 *若向量为垂直与xoz平面的向量 将无法正确返回* |
| [getLineEntitys](get-line-entitys.md) | `fun getLineEntitys(loc: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`, vector: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`? = null, maxlength: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 20.0, ρ: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 20, exit: (`[`Block`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/block/Block.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = { it.type != Material.AIR }): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Entity`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Entity.html)`>`<br>获得一条直线上的实体们 |
| [getLookAtEntity](get-look-at-entity.md) | `fun getLookAtEntity(e: `[`LivingEntity`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/LivingEntity.html)`, maxlength: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, ρ: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 50, exit: (`[`Block`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/block/Block.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = { it.type != Material.AIR }): `[`LivingEntity`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/LivingEntity.html)`?`<br>获得一个实体指针指向的实体 |
| [getOnlinePlayers](get-online-players.md) | `fun getOnlinePlayers(): `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`>`<br>合理的获取在线玩家~ |
| [getRight](get-right.md) | `fun getRight(look: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`): `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)<br>获得一个向量水平朝右的向量 *若向量为垂直与xoz平面的向量 将无法正确返回* |
| [readItemStack](read-item-stack.md) | `fun readItemStack(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)<br>读取一个指定格式的物品 |
| [safeDropItem](safe-drop-item.md) | `fun safeDropItem(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, item: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>将物品掉落在玩家周围 |
| [safeGiveItem](safe-give-item.md) | `fun safeGiveItem(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, item: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`, whenInvFull: (`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = ::safeDropItem): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>安全的添加物品到玩家背包,如果玩家背包满了. 会将物品丢弃到地上 |
| [saveResource](save-resource.md) | `fun saveResource(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`, res: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, fold: `[`File`](https://docs.oracle.com/javase/8/docs/api/java/io/File.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>数据插件jar里的文件 |
| [toYawAndPitch](to-yaw-and-pitch.md) | `fun toYawAndPitch(v: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`): `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html)<br>将向量转换为Location里使用的yaw与pitch |
