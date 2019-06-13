[BrAPI](../../index.md) / [Br.API.GUI.Ex](../index.md) / [ExUIBuilder](./index.md)

# ExUIBuilder

`open class ExUIBuilder`

**Author**
Bryan_lzh

**Version**
1.0

**Since**
2018-11-27

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ExUIBuilder(snapshotFactory: `[`SnapshotFactory`](../-snapshot-factory/index.md)`<`[`BaseUI`](../-base-u-i/index.md)`!>!)` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `open fun build(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [create](create.md) | `open static fun create(): `[`ExUIBuilder`](./index.md)<br>`open static fun create(snapshotFactory: `[`SnapshotFactory`](../-snapshot-factory/index.md)`<`[`BaseUI`](../-base-u-i/index.md)`!>!): `[`ExUIBuilder`](./index.md) |
| [displayName](display-name.md) | `open fun displayName(displayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`ExUIBuilder`](./index.md)`!` |
| [find](find.md) | `open fun find(c: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [item](item.md) | `open fun item(target: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`, i: `[`Item`](../-item/index.md)`!): `[`ExUIBuilder`](./index.md)`!`<br>`open fun item(target: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`, i: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!): `[`ExUIBuilder`](./index.md)`!`<br>`open fun item(target: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`, i: `[`ItemBuilder`](../../-br.-a-p-i/-item-builder/index.md)`!): `[`ExUIBuilder`](./index.md)`!` |
| [name](name.md) | `open fun name(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`ExUIBuilder`](./index.md)`!` |
| [onClose](on-close.md) | `open fun onClose(oc: `[`BiConsumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Snapshot`](../-snapshot/index.md)`<`[`BaseUI`](../-base-u-i/index.md)`!>!>!): `[`ExUIBuilder`](./index.md)`!` |
| [shape](shape.md) | `open fun shape(vararg shape: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`ExUIBuilder`](./index.md)`!` |
| [shift](shift.md) | `open fun shift(allowShift: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`ExUIBuilder`](./index.md)`!` |
