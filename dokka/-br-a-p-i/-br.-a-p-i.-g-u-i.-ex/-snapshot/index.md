[BrAPI](../../index.md) / [Br.API.GUI.Ex](../index.md) / [Snapshot](./index.md)

# Snapshot

`interface Snapshot<T : `[`BaseUI`](../-base-u-i/index.md)`!>`

**Author**
Bryan_lzh

**Version**
1.0

### Functions

| Name | Summary |
|---|---|
| [Delete](-delete.md) | `abstract fun ~~Delete~~(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [delete](delete.md) | `open fun delete(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getContains](get-contains.md) | `abstract fun getContains(): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`ExItem`](../-ex-item/index.md)`!>!` |
| [getData](get-data.md) | `abstract fun getData(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!` |
| [getInventory](get-inventory.md) | `abstract fun getInventory(): `[`Inventory`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html)`!` |
| [getItem](get-item.md) | `abstract fun getItem(solt: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ExItem`](../-ex-item/index.md)`!` |
| [getPlayerName](get-player-name.md) | `abstract fun getPlayerName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [getUI](get-u-i.md) | `abstract fun getUI(): `[`T`](index.md#T) |
| [removeData](remove-data.md) | `abstract fun removeData(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setData](set-data.md) | `abstract fun setData(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, value: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setInventory](set-inventory.md) | `abstract fun setInventory(inv: `[`Inventory`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [get](../../-br.-a-p-i.-g-u-i.-ex.kt/-br.-a-p-i.-g-u-i.-ex.-snapshot/get.md) | `operator fun `[`Snapshot`](./index.md)`<*>.get(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [set](../../-br.-a-p-i.-g-u-i.-ex.kt/-br.-a-p-i.-g-u-i.-ex.-snapshot/set.md) | `operator fun `[`Snapshot`](./index.md)`<*>.set(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, data: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
