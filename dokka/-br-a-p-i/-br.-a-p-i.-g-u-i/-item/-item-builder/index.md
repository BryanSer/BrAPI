[BrAPI](../../../index.md) / [Br.API.GUI](../../index.md) / [Item](../index.md) / [ItemBuilder](./index.md)

# ItemBuilder

`open class ItemBuilder : `[`Item`](../index.md)

### Inherited Properties

| Name | Summary |
|---|---|
| [Colddown](../-colddown.md) | `var Colddown: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>物品的冷却时间 单位秒 |
| [display](../display.md) | `var display: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!`<br>显示的物品 |
| [keepopen](../keepopen.md) | `var keepopen: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>玩家点击之后是否保持开启界面 |
| [LastUseTime](../-last-use-time.md) | `var LastUseTime: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`!>!` |
| [update](../update.md) | `var update: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>玩家点击之后是更新 前提是keepopen == true |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `open fun build(): `[`Item`](../index.md)`!` |
| [Do](-do.md) | `open fun Do(c: `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<`[`Item.ItemBuilder`](./index.md)`!>!): `[`Item.ItemBuilder`](./index.md)`!` |
| [doBeforeBuild](do-before-build.md) | `open fun doBeforeBuild(c: `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<`[`Item.ItemBuilder`](./index.md)`!>!): `[`Item.ItemBuilder`](./index.md)`!` |
| [getDisplay](get-display.md) | `open fun getDisplay(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!` |
| [setColddown](set-colddown.md) | `open fun setColddown(i: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Item.ItemBuilder`](./index.md)`!` |
| [setDisplay](set-display.md) | `open fun setDisplay(is: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!): `[`Item.ItemBuilder`](./index.md)`!` |
| [setDisplayMethod](set-display-method.md) | `open fun setDisplayMethod(d: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!` |
| [setKeepOpen](set-keep-open.md) | `open fun setKeepOpen(b: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Item.ItemBuilder`](./index.md)`!` |
| [setUpdate](set-update.md) | `open fun setUpdate(p: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Item.ItemBuilder`](./index.md)`!` |
| [setUse](set-use.md) | `open fun ~~setUse~~(p: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!`<br>`open fun setUse(p: `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!` |
| [setUse_Drop](set-use_-drop.md) | `open fun ~~setUse_Drop~~(p: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!`<br>`open fun setUse_Drop(p: `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!` |
| [setUse_Drop_Ctrl](set-use_-drop_-ctrl.md) | `open fun ~~setUse_Drop_Ctrl~~(p: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!`<br>`open fun setUse_Drop_Ctrl(p: `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!` |
| [setUse_Middle](set-use_-middle.md) | `open fun ~~setUse_Middle~~(p: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!`<br>`open fun setUse_Middle(p: `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!` |
| [setUse_Right](set-use_-right.md) | `open fun ~~setUse_Right~~(p: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!`<br>`open fun setUse_Right(p: `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!` |
| [setUse_Shift](set-use_-shift.md) | `open fun ~~setUse_Shift~~(p: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!`<br>`open fun setUse_Shift(p: `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!` |
| [setUse_Shift_Left](set-use_-shift_-left.md) | `open fun ~~setUse_Shift_Left~~(p: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!`<br>`open fun setUse_Shift_Left(p: `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!` |
| [setUse_Shift_Right](set-use_-shift_-right.md) | `open fun ~~setUse_Shift_Right~~(p: `[`Function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!`<br>`open fun setUse_Shift_Right(p: `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Item.ItemBuilder`](./index.md)`!` |
| [Use](-use.md) | `open fun Use(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [Use_Drop](-use_-drop.md) | `open fun Use_Drop(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [Use_Drop_Ctrl](-use_-drop_-ctrl.md) | `open fun Use_Drop_Ctrl(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [Use_Middle](-use_-middle.md) | `open fun Use_Middle(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [Use_Right](-use_-right.md) | `open fun Use_Right(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [Use_Shift](-use_-shift.md) | `open fun Use_Shift(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [Use_Shift_Left](-use_-shift_-left.md) | `open fun Use_Shift_Left(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [Use_Shift_Right](-use_-shift_-right.md) | `open fun Use_Shift_Right(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [CD](../-c-d.md) | `open fun CD(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>使一个玩家进入CD |
| [CDMessage](../-c-d-message.md) | `open fun CDMessage(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [checkCD](../check-c-d.md) | `open fun checkCD(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>检查一个玩家是否可用这个物品 |
| [clone](../clone.md) | `open fun ~~clone~~(): `[`Item`](../index.md) |
| [equals](../equals.md) | `open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getItemBuilder](../get-item-builder.md) | `open static fun getItemBuilder(): `[`Item.ItemBuilder`](./index.md)`!` |
| [hashCode](../hash-code.md) | `open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isKeepopen](../is-keepopen.md) | `open fun isKeepopen(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isNeedUpdate](../is-need-update.md) | `open fun isNeedUpdate(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
