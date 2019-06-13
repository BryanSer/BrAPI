[BrAPI](../../index.md) / [Br.API.Item](../index.md) / [ItemManager](./index.md)

# ItemManager

`abstract class ItemManager`

**Author**
Bryan_lzh

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ItemManager()` |

### Properties

| Name | Summary |
|---|---|
| [Data](-data.md) | `static var Data: `[`FileConfiguration`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/configuration/file/FileConfiguration.html)`!` |
| [ItemDatas](-item-datas.md) | `static var ItemDatas: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`ItemData`](../-item-data/index.md)`!>!` |
| [saveFolder](save-folder.md) | `static var saveFolder: `[`File`](https://docs.oracle.com/javase/8/docs/api/java/io/File.html)`!` |

### Functions

| Name | Summary |
|---|---|
| [createItem](create-item.md) | `open static fun createItem(is: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!): `[`ItemData`](../-item-data/index.md)`!`<br>创建一个新的ItemData |
| [getItemByItemStack](get-item-by-item-stack.md) | `open static fun getItemByItemStack(is: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!): `[`ItemData`](../-item-data/index.md)`!`<br>通过物品堆叠寻找ItemData |
| [getItemByName](get-item-by-name.md) | `open static fun getItemByName(u: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`ItemData`](../-item-data/index.md)`!`<br>通过唯一值寻找ItemData |
| [hasData](has-data.md) | `open static fun hasData(s: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>该物品是否储存过 |
| [loadConfig](load-config.md) | `open static fun loadConfig(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [removeDataByItem](remove-data-by-item.md) | `open static fun removeDataByItem(is: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>通过物品堆叠来删除ItemData |
| [removeDataByName](remove-data-by-name.md) | `open static fun removeDataByName(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>通过唯一值来移除某ItemData |
| [saveData](save-data.md) | `open static fun saveData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
