[BrAPI](../../../index.md) / [Br.API.GUI](../../index.md) / [Menu](../index.md) / [MenuBuilder](./index.md)

# MenuBuilder

`open class MenuBuilder : `[`Menu`](../index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MenuBuilder()` |

### Inherited Properties

| Name | Summary |
|---|---|
| [Contains](../-contains.md) | `var Contains: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Item`](../../-item/index.md)`!>!` |
| [DisplayName](../-display-name.md) | `var DisplayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [Name](../-name.md) | `var Name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [OpenItem_Dam](../-open-item_-dam.md) | `var ~~OpenItem_Dam~~: `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) |
| [OpenItem_Mate](../-open-item_-mate.md) | `var ~~OpenItem_Mate~~: `[`Material`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html)`!` |
| [Permission](../-permission.md) | `var ~~Permission~~: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [Size](../-size.md) | `var Size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SplCode](../-spl-code.md) | `static val SplCode: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [addItem](add-item.md) | `open fun addItem(i: `[`Item`](../../-item/index.md)`!): `[`Menu.MenuBuilder`](./index.md)`!` |
| [build](build.md) | `open fun build(): `[`Menu`](../index.md)`!` |
| [Do](-do.md) | `open fun Do(c: `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<`[`Menu.MenuBuilder`](./index.md)`!>!): `[`Menu.MenuBuilder`](./index.md)`!` |
| [doBeforeBuild](do-before-build.md) | `open fun doBeforeBuild(c: `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<`[`Menu.MenuBuilder`](./index.md)`!>!): `[`Menu.MenuBuilder`](./index.md)`!` |
| [fillAllWithEmpty](fill-all-with-empty.md) | `open fun fillAllWithEmpty(): `[`Menu.MenuBuilder`](./index.md)`!` |
| [fillItem](fill-item.md) | `open fun fillItem(im: `[`Item`](../../-item/index.md)`!, i: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Menu.MenuBuilder`](./index.md)`!` |
| [setDisplayname](set-displayname.md) | `open fun setDisplayname(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Menu.MenuBuilder`](./index.md)`!` |
| [setItem](set-item.md) | `open fun setItem(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, i: `[`Item`](../../-item/index.md)`!): `[`Menu.MenuBuilder`](./index.md)`!`<br>`open fun ~~setItem~~(i: `[`Item`](../../-item/index.md)`!, index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Menu.MenuBuilder`](./index.md)`!` |
| [setName](set-name.md) | `open fun setName(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Menu.MenuBuilder`](./index.md)`!` |
| [setOpenItem_Damage](set-open-item_-damage.md) | `open fun setOpenItem_Damage(s: `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)`): `[`Menu.MenuBuilder`](./index.md)`!` |
| [setOpenItem_Mate](set-open-item_-mate.md) | `open fun setOpenItem_Mate(m: `[`Material`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html)`!): `[`Menu.MenuBuilder`](./index.md)`!` |
| [setPermission](set-permission.md) | `open fun setPermission(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Menu.MenuBuilder`](./index.md)`!` |
| [setSize](set-size.md) | `open fun setSize(i: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Menu.MenuBuilder`](./index.md)`!` |

### Inherited Functions

| Name | Summary |
|---|---|
| [canOpen](../can-open.md) | `open fun canOpen(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [clone](../clone.md) | `open fun clone(): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [getBuilder](../get-builder.md) | `open static fun getBuilder(): `[`Menu.MenuBuilder`](./index.md)`!` |
| [getClick](../get-click.md) | `open fun getClick(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Item`](../../-item/index.md)`!`<br>出于可扩展性而弃用`open fun getClick(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Item`](../../-item/index.md)`!` |
| [getContains](../get-contains.md) | `open fun ~~getContains~~(): `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Item`](../../-item/index.md)`!>!`<br>`open fun getContains(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Item`](../../-item/index.md)`!>!` |
| [getDisplayName](../get-display-name.md) | `open fun getDisplayName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [getInv](../get-inv.md) | `open fun getInv(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Inventory`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html)`!` |
| [getName](../get-name.md) | `open fun getName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [getOpenItem_Dam](../get-open-item_-dam.md) | `open fun getOpenItem_Dam(): `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) |
| [getOpenItem_Mate](../get-open-item_-mate.md) | `open fun getOpenItem_Mate(): `[`Material`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html)`!` |
| [getPermission](../get-permission.md) | `open fun getPermission(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [getSize](../get-size.md) | `open fun getSize(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getSplCode](../get-spl-code.md) | `open static fun getSplCode(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
