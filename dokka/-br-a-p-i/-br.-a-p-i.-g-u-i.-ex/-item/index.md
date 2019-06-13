[BrAPI](../../index.md) / [Br.API.GUI.Ex](../index.md) / [Item](./index.md)

# Item

`open class Item : `[`ExItem`](../-ex-item/index.md)

**Author**
Bryan_lzh

**Version**
1.0

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Item()` |

### Properties

| Name | Summary |
|---|---|
| [ClickLambdas](-click-lambdas.md) | `var ClickLambdas: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`ClickType`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/ClickType.html)`!, `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!>!`<br>全部的点击事件储存于此 |
| [DisplayLambda](-display-lambda.md) | `var DisplayLambda: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!>!`<br>显示物品用 |
| [KeepOpen](-keep-open.md) | `var KeepOpen: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>玩家点击之后是否保持开启界面 |
| [onClickNotCancel](on-click-not-cancel.md) | `var onClickNotCancel: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`!>!`<br>按钮的回调函数 返回true时表示点击事件不取消 (也就是可以移动物品) |
| [UpadteDisplayLambda](-upadte-display-lambda.md) | `var UpadteDisplayLambda: `[`BiFunction`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Snapshot`](../-snapshot/index.md)`<`[`BaseUI`](../-base-u-i/index.md)`!>!, `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!>!`<br>用于更新时的Lambda 若为null将调用 |
| [Update](-update.md) | `var Update: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>玩家点击之后是更新 前提是keepopen == true |
| [UpdateIcon](-update-icon.md) | `var UpdateIcon: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>更新时是否也更新图标 |

### Functions

| Name | Summary |
|---|---|
| [getButtonPlaceable](get-button-placeable.md) | `open fun getButtonPlaceable(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getClick](get-click.md) | `open fun getClick(ct: `[`ClickType`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/ClickType.html)`!, p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, s: `[`Snapshot`](../-snapshot/index.md)`<`[`BaseUI`](../-base-u-i/index.md)`!>!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getDisplayItem](get-display-item.md) | `open fun getDisplayItem(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, s: `[`Snapshot`](../-snapshot/index.md)`<`[`BaseUI`](../-base-u-i/index.md)`!>!): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!` |
| [getNewInstance](get-new-instance.md) | `open static fun getNewInstance(display: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!>!): `[`Item`](./index.md)`!`<br>创建一个新的Item`open static fun getNewInstance(display: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!): `[`Item`](./index.md)`!` |
| [getNewInstanceOfSlot](get-new-instance-of-slot.md) | `open static fun getNewInstanceOfSlot(): `[`Item`](./index.md)`!` |
| [isKeepOpen](is-keep-open.md) | `open fun isKeepOpen(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isUpdate](is-update.md) | `open fun isUpdate(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isUpdateIcon](is-update-icon.md) | `open fun isUpdateIcon(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [setButtonCellback](set-button-cellback.md) | `open fun setButtonCellback(b: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`!>!): `[`Item`](./index.md)`!` |
| [setButtonPutable](set-button-putable.md) | `open fun setButtonPutable(b: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`!>!): `[`Item`](./index.md)`!` |
| [setClick](set-click.md) | `open fun setClick(ct: `[`ClickType`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/ClickType.html)`!, c: `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Item`](./index.md)`!` |
| [setDisplay](set-display.md) | `open fun setDisplay(f: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!>!): `[`Item`](./index.md)`!` |
| [setKeepOpen](set-keep-open.md) | `open fun setKeepOpen(ko: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Item`](./index.md)`!` |
| [setUpadteDisplayLambda](set-upadte-display-lambda.md) | `open fun setUpadteDisplayLambda(UpadteDisplayLambda: `[`BiFunction`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Snapshot`](../-snapshot/index.md)`<`[`BaseUI`](../-base-u-i/index.md)`!>!, `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!>!): `[`Item`](./index.md)`!` |
| [setUpdate](set-update.md) | `open fun setUpdate(u: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Item`](./index.md)`!` |
| [setUpdateIcon](set-update-icon.md) | `open fun setUpdateIcon(UpdateIcon: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Item`](./index.md)`!` |
| [update](update.md) | `open fun update(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, s: `[`Snapshot`](../-snapshot/index.md)`<`[`BaseUI`](../-base-u-i/index.md)`!>!): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!` |

### Inherited Functions

| Name | Summary |
|---|---|
| [getClickLambda](../-ex-item/get-click-lambda.md) | `open fun getClickLambda(ct: `[`ClickType`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/ClickType.html)`!, p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, s: `[`Snapshot`](../-snapshot/index.md)`<`[`BaseUI`](../-base-u-i/index.md)`!>!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
