[BrAPI](../../index.md) / [Br.API.Map](../index.md) / [SortableMap](./index.md)

# SortableMap

`open class SortableMap<K : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!, V : `[`Comparable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?>!> : `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`K`](index.md#K)`, `[`V`](index.md#V)`>`

**Author**
Administrator

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SortableMap()` |

### Properties

| Name | Summary |
|---|---|
| [entries](entries.md) | `open val entries: `[`MutableSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)`<`[`MutableEntry`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/-mutable-entry/index.html)`<`[`K`](index.md#K)`, `[`V`](index.md#V)`>>` |
| [size](size.md) | `open val size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | `open fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [containsKey](contains-key.md) | `open fun containsKey(key: `[`K`](index.md#K)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [containsValue](contains-value.md) | `open fun containsValue(value: `[`V`](index.md#V)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [get](get.md) | `open fun get(key: `[`K`](index.md#K)`): `[`V`](index.md#V)`?` |
| [isEmpty](is-empty.md) | `open fun isEmpty(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [keySet](key-set.md) | `open fun keySet(): `[`MutableSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?>!` |
| [put](put.md) | `open fun put(key: `[`K`](index.md#K)`, value: `[`V`](index.md#V)`): `[`V`](index.md#V)`?` |
| [putAll](put-all.md) | `open fun putAll(from: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [remove](remove.md) | `open fun remove(key: `[`K`](index.md#K)`): `[`V`](index.md#V)`?` |
| [sortMapByValue](sort-map-by-value.md) | `open fun sortMapByValue(): `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`K`](index.md#K)`, `[`V`](index.md#V)`>!`<br>返回排序的结果`open fun sortMapByValue(com: `[`Comparator`](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)`<`[`MutableEntry`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/-mutable-entry/index.html)`<`[`K`](index.md#K)`, `[`V`](index.md#V)`>!>!): `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`K`](index.md#K)`, `[`V`](index.md#V)`>!` |
| [values](values.md) | `open fun values(): `[`MutableCollection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-collection/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?>!` |
