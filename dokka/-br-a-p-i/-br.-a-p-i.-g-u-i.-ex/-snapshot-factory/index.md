[BrAPI](../../index.md) / [Br.API.GUI.Ex](../index.md) / [SnapshotFactory](./index.md)

# SnapshotFactory

`abstract class SnapshotFactory<T : `[`BaseUI`](../-base-u-i/index.md)`!>`

**Author**
Bryan_lzh

**Version**
1.0

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SnapshotFactory(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!)`<br>`SnapshotFactory()` |

### Properties

| Name | Summary |
|---|---|
| [LastSnapshot](-last-snapshot.md) | `var LastSnapshot: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`Snapshot`](../-snapshot/index.md)`<`[`T`](index.md#T)`>!>!` |

### Functions

| Name | Summary |
|---|---|
| [createSnapshot](create-snapshot.md) | `abstract fun createSnapshot(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, ui: `[`T`](index.md#T)`): `[`Snapshot`](../-snapshot/index.md)`<`[`T`](index.md#T)`>!` |
| [deleteSanpshop](delete-sanpshop.md) | `open fun ~~deleteSanpshop~~(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [deleteSnapshot](delete-snapshot.md) | `open fun deleteSnapshot(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getDefaultSnapshotFactory](get-default-snapshot-factory.md) | `open static fun <T : `[`BaseUI`](../-base-u-i/index.md)`!> getDefaultSnapshotFactory(): `[`SnapshotFactory`](./index.md)`<`[`T`](get-default-snapshot-factory.md#T)`>!`<br>`open static fun <T : `[`BaseUI`](../-base-u-i/index.md)`!> getDefaultSnapshotFactory(ui: `[`T`](get-default-snapshot-factory.md#T)`): `[`SnapshotFactory`](./index.md)`<`[`T`](get-default-snapshot-factory.md#T)`>!`<br>`open static fun <T : `[`BaseUI`](../-base-u-i/index.md)`!> getDefaultSnapshotFactory(ui: `[`T`](get-default-snapshot-factory.md#T)`, oncreate: `[`BiConsumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>!>!): `[`SnapshotFactory`](./index.md)`<`[`T`](get-default-snapshot-factory.md#T)`>!`<br>`open static fun <T : `[`BaseUI`](../-base-u-i/index.md)`!> getDefaultSnapshotFactory(oncreate: `[`BiConsumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>!>!): `[`SnapshotFactory`](./index.md)`<`[`T`](get-default-snapshot-factory.md#T)`>!` |
| [getNewSnapshot](get-new-snapshot.md) | `open fun getNewSnapshot(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, ui: `[`T`](index.md#T)`): `[`Snapshot`](../-snapshot/index.md)`<`[`T`](index.md#T)`>!` |
| [getSnapshot](get-snapshot.md) | `open fun getSnapshot(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Snapshot`](../-snapshot/index.md)`<`[`T`](index.md#T)`>!` |
