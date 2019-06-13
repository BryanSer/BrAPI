[BrAPI](../../../index.md) / [Br.API.ParticleEffect](../../index.md) / [ReflectionUtils](../index.md) / [DataType](index.md) / [getPrimitive](./get-primitive.md)

# getPrimitive

`fun getPrimitive(): `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!`

Returns the primitive class of this data type

**Return**
[Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!: The primitive class

`static fun getPrimitive(clazz: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!): `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!`

Returns the primitive class of the data type with the given reference class

### Parameters

`clazz` - [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!: Reference class of the data type

**Return**
[Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!: The primitive class

`static fun getPrimitive(classes: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!>!): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!>!`

Returns the primitive class array of the given class array

### Parameters

`classes` - [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!&gt;!: Given class array

**Return**
[Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!&gt;!: The primitive class array

`static fun getPrimitive(objects: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>!): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!>!`

Returns the primitive class array of the given object array

### Parameters

`objects` - [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!&gt;!: Given object array

**Return**
[Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!&gt;!: The primitive class array

