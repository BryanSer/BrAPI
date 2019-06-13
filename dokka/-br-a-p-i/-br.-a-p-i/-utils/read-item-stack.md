[BrAPI](../../index.md) / [Br.API](../index.md) / [Utils](index.md) / [readItemStack](./read-item-stack.md)

# readItemStack

`open static fun readItemStack(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!`

配置文件物品解析.

 格式: ID 数量 损伤值

 可选: Name:名字 Lore:Lore Color:RED(用于染料羊毛) 或 Color:RGB(用于皮革) Ench:附魔Id-附魔等级

### Parameters

`s` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: String 字符串

**Return**
[ItemStack](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)!: ItemStack

`open static fun ~~readItemStack~~(config: `[`FileConfiguration`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/configuration/file/FileConfiguration.html)`!, path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!>!`
**Deprecated:** Deprecated in Java

批量解析

### Parameters

`config` - [FileConfiguration](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/configuration/file/FileConfiguration.html)!: 配置文件

`path` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: 路径

**Return**
[MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[ItemStack](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)!&gt;!: List 按顺序读取的ItemStack

