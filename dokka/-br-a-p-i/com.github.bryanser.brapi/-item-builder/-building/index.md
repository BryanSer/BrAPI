[BrAPI](../../../index.md) / [com.github.bryanser.brapi](../../index.md) / [ItemBuilder](../index.md) / [Building](./index.md)

# Building

`data class Building` [(source)](https://github.com/BryanSer/BrAPI/raw/ver-kotlin/src/main/kotlin/com/github/bryanser/brapi/ItemBuilder.kt#L57)

物品构造器

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Building(material: `[`Material`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html)`)`<br>物品构造器 |

### Properties

| Name | Summary |
|---|---|
| [amount](amount.md) | `var amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>物品数量 |
| [displayName](display-name.md) | `var displayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>物品显示名 |
| [durability](durability.md) | `var durability: `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)<br>物品损伤值 |
| [ench](ench.md) | `var ench: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`Enchantment`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/enchantments/Enchantment.html)`, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?`<br>物品附魔 |
| [lore](lore.md) | `var lore: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?`<br>物品Lore |
| [material](material.md) | `val material: `[`Material`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html)<br>物品类型 |
| [unbreakable](unbreakable.md) | `var unbreakable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>是否不可破坏 |

### Functions

| Name | Summary |
|---|---|
| [amount](amount.md) | `infix fun amount(v: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ItemBuilder.Building`](./index.md) |
| [build](build.md) | `fun build(): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)<br>构造物品 |
| [durability](durability.md) | `infix fun durability(dur: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ItemBuilder.Building`](./index.md) |
| [ench](ench.md) | `infix fun ench(pair: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Enchantment`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/enchantments/Enchantment.html)`, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>): `[`ItemBuilder.Building`](./index.md) |
| [invoke](invoke.md) | `operator fun invoke(): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html) |
| [lore](lore.md) | `infix fun lore(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ItemBuilder.Building`](./index.md)<br>`infix fun lore(s: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`ItemBuilder.Building`](./index.md)<br>`infix fun lore(func: (`[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`ItemBuilder.Building`](./index.md) |
| [name](name.md) | `infix fun name(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ItemBuilder.Building`](./index.md) |
| [plus](plus.md) | `operator fun plus(s: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`ItemBuilder.Building`](./index.md)<br>`operator fun plus(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ItemBuilder.Building`](./index.md) |
| [plusAssign](plus-assign.md) | `operator fun plusAssign(s: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`operator fun plusAssign(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [unbreakable](unbreakable.md) | `infix fun unbreakable(u: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`ItemBuilder.Building`](./index.md) |
