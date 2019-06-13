[BrAPI](../../index.md) / [Br.API.GUI.Ex](../index.md) / [ExItem](./index.md)

# ExItem

`interface ExItem`

### Functions

| Name | Summary |
|---|---|
| [getButtonPlaceable](get-button-placeable.md) | `abstract fun getButtonPlaceable(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getClick](get-click.md) | `abstract fun getClick(ct: `[`ClickType`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/ClickType.html)`!, p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, s: `[`Snapshot`](../-snapshot/index.md)`<`[`BaseUI`](../-base-u-i/index.md)`!>!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getClickLambda](get-click-lambda.md) | `open fun getClickLambda(ct: `[`ClickType`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/ClickType.html)`!, p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, s: `[`Snapshot`](../-snapshot/index.md)`<`[`BaseUI`](../-base-u-i/index.md)`!>!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getDisplayItem](get-display-item.md) | `abstract fun getDisplayItem(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, s: `[`Snapshot`](../-snapshot/index.md)`<`[`BaseUI`](../-base-u-i/index.md)`!>!): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!` |
| [isKeepOpen](is-keep-open.md) | `abstract fun isKeepOpen(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isUpdate](is-update.md) | `abstract fun isUpdate(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isUpdateIcon](is-update-icon.md) | `abstract fun isUpdateIcon(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [update](update.md) | `abstract fun update(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, s: `[`Snapshot`](../-snapshot/index.md)`<`[`BaseUI`](../-base-u-i/index.md)`!>!): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!` |

### Inheritors

| Name | Summary |
|---|---|
| [Item](../-item/index.md) | `open class Item : `[`ExItem`](./index.md) |
| [KtItem](../../-br.-a-p-i.-g-u-i.-ex.kt/-kt-item/index.md) | `class KtItem : `[`ExItem`](./index.md) |
