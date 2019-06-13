[BrAPI](../../index.md) / [Br.API.GUI.Ex.kt](../index.md) / [KtUI](./index.md)

# KtUI

`abstract class KtUI : `[`BaseUI`](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `KtUI(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, displayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, rows: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, allowShift: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, playerInit: `[`SnapshotFactoryInit`](../-snapshot-factory-init.md)`? = null)`<br>`KtUI(builder: `[`KtUIBuilder`](../-kt-u-i-builder/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [factory](factory.md) | `var factory: `[`SnapshotFactory`](../../-br.-a-p-i.-g-u-i.-ex/-snapshot-factory/index.md)`<*>` |
| [playerInit](player-init.md) | `var playerInit: `[`SnapshotFactoryInit`](../-snapshot-factory-init.md)`?` |

### Inherited Properties

| Name | Summary |
|---|---|
| [AllowShift](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/-allow-shift.md) | `var AllowShift: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [DisplayName](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/-display-name.md) | `var DisplayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [Name](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/-name.md) | `var Name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [Rows](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/-rows.md) | `var Rows: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [getSnapshotFactory](get-snapshot-factory.md) | `open fun getSnapshotFactory(): `[`SnapshotFactory`](../../-br.-a-p-i.-g-u-i.-ex/-snapshot-factory/index.md)`<*>` |

### Inherited Functions

| Name | Summary |
|---|---|
| [getDisplayName](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/get-display-name.md) | `open fun getDisplayName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [getExItem](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/get-ex-item.md) | `open fun getExItem(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, slot: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ExItem`](../../-br.-a-p-i.-g-u-i.-ex/-ex-item/index.md)`!` |
| [getItem](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/get-item.md) | `abstract fun getItem(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, slot: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Item`](../../-br.-a-p-i.-g-u-i.-ex/-item/index.md)`!`<br>获取某个位置的物品 |
| [getName](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/get-name.md) | `open fun getName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [getRows](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/get-rows.md) | `open fun getRows(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getSize](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/get-size.md) | `open fun getSize(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getSnapshot](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/get-snapshot.md) | `open fun getSnapshot(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Snapshot`](../../-br.-a-p-i.-g-u-i.-ex/-snapshot/index.md)`<`[`BaseUI`](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/index.md)`!>!` |
| [isAllowShift](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/is-allow-shift.md) | `open fun isAllowShift(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onClose](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/on-close.md) | `open fun onClose(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, s: `[`Snapshot`](../../-br.-a-p-i.-g-u-i.-ex/-snapshot/index.md)`<`[`BaseUI`](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/index.md)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
