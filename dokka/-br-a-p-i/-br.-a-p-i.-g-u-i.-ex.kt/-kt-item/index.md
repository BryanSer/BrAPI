[BrAPI](../../index.md) / [Br.API.GUI.Ex.kt](../index.md) / [KtItem](./index.md)

# KtItem

`class KtItem : `[`ExItem`](../../-br.-a-p-i.-g-u-i.-ex/-ex-item/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `KtItem(keepOpen: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, update: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, updateIcon: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true)` |

### Properties

| Name | Summary |
|---|---|
| [buttonPlaceable](button-placeable.md) | `var buttonPlaceable: `[`ButtonPlaceable`](../-button-placeable.md)`?` |
| [clicks](clicks.md) | `val clicks: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`ClickType`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/ClickType.html)`, `[`Click`](../-click.md)`>` |
| [display](display.md) | `var display: `[`Display`](../-display.md) |
| [keepOpen](keep-open.md) | `var keepOpen: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [update](update.md) | `var update: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [updateDisplay](update-display.md) | `var updateDisplay: `[`Display`](../-display.md)`?` |
| [updateIcon](update-icon.md) | `var updateIcon: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [click](click.md) | `infix fun click(clk: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`ClickType`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/ClickType.html)`, `[`Click`](../-click.md)`>): `[`KtItem`](./index.md)<br>`infix fun click(clk: `[`Click`](../-click.md)`): `[`KtItem`](./index.md) |
| [display](display.md) | `infix fun display(dis: `[`Display`](../-display.md)`): `[`KtItem`](./index.md)<br>`infix fun display(item: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`?): `[`KtItem`](./index.md) |
| [getButtonPlaceable](get-button-placeable.md) | `fun getButtonPlaceable(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getClick](get-click.md) | `fun getClick(ct: `[`ClickType`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/ClickType.html)`, p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, s: `[`Snapshot`](../../-br.-a-p-i.-g-u-i.-ex/-snapshot/index.md)`<*>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getDisplayItem](get-display-item.md) | `fun getDisplayItem(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, s: `[`Snapshot`](../../-br.-a-p-i.-g-u-i.-ex/-snapshot/index.md)`<*>): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`?` |
| [isKeepOpen](is-keep-open.md) | `fun isKeepOpen(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isUpdate](is-update.md) | `fun isUpdate(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isUpdateIcon](is-update-icon.md) | `fun isUpdateIcon(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keepOpen](keep-open.md) | `infix fun keepOpen(ko: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`KtItem`](./index.md) |
| [placeable](placeable.md) | `infix fun placeable(bp: `[`ButtonPlaceable`](../-button-placeable.md)`): `[`KtItem`](./index.md) |
| [update](update.md) | `infix fun update(u: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`KtItem`](./index.md)<br>`infix fun update(dis: `[`Display`](../-display.md)`): `[`KtItem`](./index.md)<br>`fun update(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, s: `[`Snapshot`](../../-br.-a-p-i.-g-u-i.-ex/-snapshot/index.md)`<*>): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`?` |
| [updateIcon](update-icon.md) | `infix fun updateIcon(ui: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`KtItem`](./index.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [getClickLambda](../../-br.-a-p-i.-g-u-i.-ex/-ex-item/get-click-lambda.md) | `open fun getClickLambda(ct: `[`ClickType`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/ClickType.html)`!, p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, s: `[`Snapshot`](../../-br.-a-p-i.-g-u-i.-ex/-snapshot/index.md)`<`[`BaseUI`](../../-br.-a-p-i.-g-u-i.-ex/-base-u-i/index.md)`!>!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [newEmptySlot](new-empty-slot.md) | `fun newEmptySlot(): `[`KtItem`](./index.md) |
| [newItem](new-item.md) | `fun newItem(): `[`KtItem`](./index.md) |
