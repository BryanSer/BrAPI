[BrAPI](../../index.md) / [Br.API.Item](../index.md) / [ItemManage](./index.md)

# ItemManage

`abstract class ItemManage`

**Author**
Administrator

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ItemManage()` |

### Functions

| Name | Summary |
|---|---|
| [createItem](create-item.md) | `open static fun ~~createItem~~(is: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!): `[`ItemData`](../-item-data/index.md)`!`<br>创建一个新的ItemData |
| [getItemByItemStack](get-item-by-item-stack.md) | `open static fun ~~getItemByItemStack~~(is: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!): `[`ItemData`](../-item-data/index.md)`!`<br>通过物品堆叠寻找ItemData |
| [getItemByName](get-item-by-name.md) | `open static fun ~~getItemByName~~(u: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`ItemData`](../-item-data/index.md)`!`<br>通过唯一值寻找ItemData |
| [hasData](has-data.md) | `open static fun ~~hasData~~(s: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>该物品是否储存过 |
| [removeDataByItem](remove-data-by-item.md) | `open static fun ~~removeDataByItem~~(is: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>通过物品堆叠来删除ItemData |
| [removeDataByName](remove-data-by-name.md) | `open static fun ~~removeDataByName~~(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>通过唯一值来移除某ItemData |
