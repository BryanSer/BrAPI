[BrAPI](../../index.md) / [Br.API.NBT](../index.md) / [BrNBTTagCompound](./index.md)

# BrNBTTagCompound

`open class BrNBTTagCompound : `[`BrNBTBase`](../-br-n-b-t-base/index.md)

**Author**
Bryan_lzh

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BrNBTTagCompound()`<br>`BrNBTTagCompound(obj: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [TargetClass](../-br-n-b-t-base/-target-class.md) | `var TargetClass: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!` |
| [TargetObject](../-br-n-b-t-base/-target-object.md) | `var TargetObject: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!` |

### Functions

| Name | Summary |
|---|---|
| [getCompound](get-compound.md) | `open fun getCompound(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`BrNBTTagCompound`](./index.md)`!` |
| [getKeySet](get-key-set.md) | `open fun getKeySet(): `[`MutableSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!>!` |
| [getNBTBase](get-n-b-t-base.md) | `open fun getNBTBase(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`BrNBTBase`](../-br-n-b-t-base/index.md)`!` |
| [hasValue](has-value.md) | `open fun hasValue(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [set](set.md) | `open fun set(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, nbt: `[`BrNBTBase`](../-br-n-b-t-base/index.md)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [getNumber](../-br-n-b-t-base/get-number.md) | `open static fun getNumber(num: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`BrNBTBase`](../-br-n-b-t-base/index.md)`!` |
| [getTargetClass](../-br-n-b-t-base/get-target-class.md) | `open fun getTargetClass(): `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!` |
| [getTargetObject](../-br-n-b-t-base/get-target-object.md) | `open fun getTargetObject(): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!` |
| [toBase](../-br-n-b-t-base/to-base.md) | `open static fun toBase(obj: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`BrNBTBase`](../-br-n-b-t-base/index.md)`!` |
