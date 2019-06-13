[BrAPI](../../index.md) / [Br.API.NBT](../index.md) / [BrNBTBase](./index.md)

# BrNBTBase

`open class BrNBTBase`

**Author**
Bryan_lzh

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BrNBTBase()`<br>`BrNBTBase(i: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)`<br>`BrNBTBase(i: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`)`<br>`BrNBTBase(i: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`)`<br>`BrNBTBase(i: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`)`<br>`BrNBTBase(i: `[`Short`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)`)`<br>`BrNBTBase(i: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [TargetClass](-target-class.md) | `var TargetClass: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!` |
| [TargetObject](-target-object.md) | `var TargetObject: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!` |

### Functions

| Name | Summary |
|---|---|
| [getNumber](get-number.md) | `open static fun getNumber(num: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`BrNBTBase`](./index.md)`!` |
| [getTargetClass](get-target-class.md) | `open fun getTargetClass(): `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!` |
| [getTargetObject](get-target-object.md) | `open fun getTargetObject(): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!` |
| [toBase](to-base.md) | `open static fun toBase(obj: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`BrNBTBase`](./index.md)`!` |

### Inheritors

| Name | Summary |
|---|---|
| [BrNBTTagCompound](../-br-n-b-t-tag-compound/index.md) | `open class BrNBTTagCompound : `[`BrNBTBase`](./index.md) |
| [BrNBTTagList](../-br-n-b-t-tag-list/index.md) | `open class BrNBTTagList : `[`BrNBTBase`](./index.md) |
| [BrNBTTagString](../-br-n-b-t-tag-string/index.md) | `open class BrNBTTagString : `[`BrNBTBase`](./index.md) |
