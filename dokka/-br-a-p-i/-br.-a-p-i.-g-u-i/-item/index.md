[BrAPI](../../index.md) / [Br.API.GUI](../index.md) / [Item](./index.md)

# Item

`abstract class Item : `[`Cloneable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-cloneable/index.html)

**Author**
Bryan_lzh

### Types

| Name | Summary |
|---|---|
| [ItemBuilder](-item-builder/index.md) | `open class ItemBuilder : `[`Item`](./index.md) |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Item()`<br>`Item(keep: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [Colddown](-colddown.md) | `var Colddown: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>物品的冷却时间 单位秒 |
| [display](display.md) | `var display: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!`<br>显示的物品 |
| [keepopen](keepopen.md) | `var keepopen: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>玩家点击之后是否保持开启界面 |
| [LastUseTime](-last-use-time.md) | `var LastUseTime: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`!>!` |
| [update](update.md) | `var update: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>玩家点击之后是更新 前提是keepopen == true |

### Functions

| Name | Summary |
|---|---|
| [CD](-c-d.md) | `open fun CD(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>使一个玩家进入CD |
| [CDMessage](-c-d-message.md) | `open fun CDMessage(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [checkCD](check-c-d.md) | `open fun checkCD(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>检查一个玩家是否可用这个物品 |
| [clone](clone.md) | `open fun ~~clone~~(): `[`Item`](./index.md) |
| [equals](equals.md) | `open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getDisplay](get-display.md) | `open fun getDisplay(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!` |
| [getItemBuilder](get-item-builder.md) | `open static fun getItemBuilder(): `[`Item.ItemBuilder`](-item-builder/index.md)`!` |
| [hashCode](hash-code.md) | `open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isKeepopen](is-keepopen.md) | `open fun isKeepopen(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isNeedUpdate](is-need-update.md) | `open fun isNeedUpdate(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [Use](-use.md) | `abstract fun Use(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>当一个玩家左键点击之后触发本方法 |
| [Use_Drop](-use_-drop.md) | `open fun Use_Drop(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>玩家对物品按下Q时触发 |
| [Use_Drop_Ctrl](-use_-drop_-ctrl.md) | `open fun Use_Drop_Ctrl(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>玩家按住ctrl时按下Q时触发 |
| [Use_Middle](-use_-middle.md) | `open fun Use_Middle(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>玩家对物品按下中键时触发 |
| [Use_Right](-use_-right.md) | `open fun Use_Right(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [Use_Shift](-use_-shift.md) | `open fun Use_Shift(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [Use_Shift_Left](-use_-shift_-left.md) | `open fun Use_Shift_Left(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [Use_Shift_Right](-use_-shift_-right.md) | `open fun Use_Shift_Right(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ItemBuilder](-item-builder/index.md) | `open class ItemBuilder : `[`Item`](./index.md) |
