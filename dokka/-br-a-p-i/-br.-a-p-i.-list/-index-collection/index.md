[BrAPI](../../index.md) / [Br.API.List](../index.md) / [IndexCollection](./index.md)

# IndexCollection

`open class IndexCollection<T : `[`Indexable`](../-indexable/index.md)`!> : `[`MutableCollection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-collection/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?>`

用于按序号储存的容器

**Author**
Administrator

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `IndexCollection()`<br>用于按序号储存的容器 |

### Properties

| Name | Summary |
|---|---|
| [size](size.md) | `open val size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `open fun add(t: `[`T`](index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun add(element: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [addAll](add-all.md) | `open fun addAll(elements: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [clear](clear.md) | `open fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [contains](contains.md) | `open fun contains(element: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [containsAll](contains-all.md) | `open fun containsAll(elements: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [get](get.md) | `open fun get(i: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`T`](index.md#T) |
| [getData](get-data.md) | `open fun getData(): `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`!, `[`T`](index.md#T)`>!`<br>请勿利用此返回值进行除读取外的数据操作 |
| [getIndexs](get-indexs.md) | `open fun getIndexs(): `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`!>!` |
| [getMaxIndex](get-max-index.md) | `open fun getMaxIndex(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isEmpty](is-empty.md) | `open fun isEmpty(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [iterator](iterator.md) | `open fun iterator(): `[`MutableIterator`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-iterator/index.html)`<`[`T`](index.md#T)`>` |
| [remove](remove.md) | `open fun remove(t: `[`T`](index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun remove(i: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open fun remove(element: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [removeAll](remove-all.md) | `open fun removeAll(elements: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [retainAll](retain-all.md) | `open fun retainAll(elements: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [toArray](to-array.md) | `open fun toArray(): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>!`<br>`open fun toArray(a: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>!): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>!` |
