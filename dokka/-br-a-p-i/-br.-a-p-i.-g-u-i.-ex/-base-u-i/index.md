[BrAPI](../../index.md) / [Br.API.GUI.Ex](../index.md) / [BaseUI](./index.md)

# BaseUI

`abstract class BaseUI`

**Author**
Bryan_lzh

**Version**
1.0

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BaseUI()` |

### Properties

| Name | Summary |
|---|---|
| [AllowShift](-allow-shift.md) | `var AllowShift: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [DisplayName](-display-name.md) | `var DisplayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [Name](-name.md) | `var Name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [Rows](-rows.md) | `var Rows: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [getDisplayName](get-display-name.md) | `open fun getDisplayName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [getExItem](get-ex-item.md) | `open fun getExItem(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, slot: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ExItem`](../-ex-item/index.md)`!` |
| [getItem](get-item.md) | `abstract fun getItem(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, slot: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Item`](../-item/index.md)`!`<br>获取某个位置的物品 |
| [getName](get-name.md) | `open fun getName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [getRows](get-rows.md) | `open fun getRows(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getSize](get-size.md) | `open fun getSize(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getSnapshot](get-snapshot.md) | `open fun getSnapshot(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Snapshot`](../-snapshot/index.md)`<`[`BaseUI`](./index.md)`!>!` |
| [getSnapshotFactory](get-snapshot-factory.md) | `abstract fun getSnapshotFactory(): `[`SnapshotFactory`](../-snapshot-factory/index.md)`<`[`BaseUI`](./index.md)`!>!`<br>警告 每次调用这个方法必须返回同一个对象 |
| [isAllowShift](is-allow-shift.md) | `open fun isAllowShift(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onClose](on-close.md) | `open fun onClose(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, s: `[`Snapshot`](../-snapshot/index.md)`<`[`BaseUI`](./index.md)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [KtUI](../../-br.-a-p-i.-g-u-i.-ex.kt/-kt-u-i/index.md) | `abstract class KtUI : `[`BaseUI`](./index.md) |
