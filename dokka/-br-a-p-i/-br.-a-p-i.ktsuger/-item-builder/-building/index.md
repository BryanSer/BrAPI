[BrAPI](../../../index.md) / [Br.API.ktsuger](../../index.md) / [ItemBuilder](../index.md) / [Building](./index.md)

# Building

`data class Building`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Building(material: `[`Material`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [amount](amount.md) | `var amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [displayName](display-name.md) | `var displayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [durability](durability.md) | `var durability: `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) |
| [ench](ench.md) | `var ench: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`Enchantment`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/enchantments/Enchantment.html)`, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?` |
| [lore](lore.md) | `var lore: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?` |
| [material](material.md) | `val material: `[`Material`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html) |
| [unbreakable](unbreakable.md) | `var unbreakable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [amount](amount.md) | `infix fun amount(v: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ItemBuilder.Building`](./index.md) |
| [build](build.md) | `fun build(): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html) |
| [durability](durability.md) | `infix fun durability(dur: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ItemBuilder.Building`](./index.md) |
| [ench](ench.md) | `infix fun ench(pair: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Enchantment`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/enchantments/Enchantment.html)`, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>): `[`ItemBuilder.Building`](./index.md) |
| [invoke](invoke.md) | `operator fun invoke(): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html) |
| [lore](lore.md) | `infix fun lore(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ItemBuilder.Building`](./index.md)<br>`infix fun lore(s: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`ItemBuilder.Building`](./index.md)<br>`infix fun lore(func: (`[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`ItemBuilder.Building`](./index.md) |
| [name](name.md) | `infix fun name(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ItemBuilder.Building`](./index.md) |
| [plus](plus.md) | `operator fun plus(s: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`ItemBuilder.Building`](./index.md)<br>`operator fun plus(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ItemBuilder.Building`](./index.md) |
| [plusAssign](plus-assign.md) | `operator fun plusAssign(s: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`operator fun plusAssign(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [unbreakable](unbreakable.md) | `infix fun unbreakable(u: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`ItemBuilder.Building`](./index.md) |
