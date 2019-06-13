[BrAPI](../../index.md) / [Br.API.Map](../index.md) / [TowwayMap](./index.md)

# TowwayMap

`open class TowwayMap<K : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!, V : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!> : `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`K`](index.md#K)`, `[`V`](index.md#V)`>`

闲着无聊写的双向Map 虽然本质还是HashMap

**Author**
Bryan_lzh

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TowwayMap()`<br>闲着无聊写的双向Map 虽然本质还是HashMap |

### Properties

| Name | Summary |
|---|---|
| [entries](entries.md) | `open val entries: `[`MutableSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)`<`[`MutableEntry`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/-mutable-entry/index.html)`<`[`K`](index.md#K)`, `[`V`](index.md#V)`>>` |
| [keys](keys.md) | `open val keys: `[`MutableSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)`<`[`K`](index.md#K)`>` |
| [size](size.md) | `open val size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [values](values.md) | `open val values: `[`MutableCollection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-collection/index.html)`<`[`V`](index.md#V)`>` |

### Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | `open fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [containsKey](contains-key.md) | `open fun containsKey(key: `[`K`](index.md#K)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [containsValue](contains-value.md) | `open fun containsValue(value: `[`V`](index.md#V)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [get](get.md) | `open fun get(key: `[`K`](index.md#K)`): `[`V`](index.md#V)`?` |
| [getKey](get-key.md) | `open fun getKey(value: `[`V`](index.md#V)`): `[`K`](index.md#K)<br>通过V找K |
| [isEmpty](is-empty.md) | `open fun isEmpty(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [put](put.md) | `open fun put(key: `[`K`](index.md#K)`, value: `[`V`](index.md#V)`): `[`V`](index.md#V)`?` |
| [putAll](put-all.md) | `open fun putAll(from: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [remove](remove.md) | `open fun remove(key: `[`K`](index.md#K)`): `[`V`](index.md#V)`?` |
