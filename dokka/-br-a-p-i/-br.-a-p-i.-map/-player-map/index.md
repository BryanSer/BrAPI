[BrAPI](../../index.md) / [Br.API.Map](../index.md) / [PlayerMap](./index.md)

# PlayerMap

`open class PlayerMap<V : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!> : `[`HashMap`](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`V`](index.md#V)`>`

**Author**
Bryan_lzh

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PlayerMap()`<br>`PlayerMap(initialCapacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, loadFactor: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`)`<br>`PlayerMap(initialCapacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)`<br>`PlayerMap(m: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, out `[`V`](index.md#V)`>!)` |

### Functions

| Name | Summary |
|---|---|
| [get](get.md) | `open fun get(key: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`V`](index.md#V) |
| [put](put.md) | `open fun put(key: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, value: `[`V`](index.md#V)`): `[`V`](index.md#V) |
| [remove](remove.md) | `open fun remove(key: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`V`](index.md#V) |
