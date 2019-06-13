[BrAPI](../../index.md) / [Br.API.GUI](../index.md) / [MenuManager](./index.md)

# MenuManager

`open class MenuManager`

**Author**
Bryan_lzh

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MenuManager()` |

### Properties

| Name | Summary |
|---|---|
| [MenuItems](-menu-items.md) | `static var MenuItems: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`CheckItem`](../-check-item/index.md)`!, `[`Menu`](../-menu/index.md)`!>!` |
| [Menus](-menus.md) | `static var Menus: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`Menu`](../-menu/index.md)`!>!` |
| [registered](registered.md) | `static var registered: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [deCode](de-code.md) | `open static fun deCode(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [getMenu](get-menu.md) | `open static fun getMenu(inv: `[`Inventory`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html)`!): `[`Menu`](../-menu/index.md)`!` |
| [OpenMenu](-open-menu.md) | `open static fun OpenMenu(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, menu: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [OpenMenuDelay](-open-menu-delay.md) | `open static fun OpenMenuDelay(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, menu: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [RegisterMenu](-register-menu.md) | `open static fun RegisterMenu(m: `[`Menu`](../-menu/index.md)`!, old: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>注册菜单`open static fun RegisterMenu(m: `[`Menu`](../-menu/index.md)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>注册菜单 默认采用Ex版完成UI处理 |
| [toCode](to-code.md) | `open static fun toCode(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [UpdateMenu](-update-menu.md) | `open static fun UpdateMenu(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
