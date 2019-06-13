[BrAPI](../../../index.md) / [Br.API.ParticleEffect](../../index.md) / [ReflectionUtils](../index.md) / [DataType](./index.md)

# DataType

`class DataType`

Represents an enumeration of Java data types with corresponding classes

 This class is part of the **ReflectionUtils** and follows the same usage conditions

**Author**
DarkBlade12

**Since**
1.0

### Enum Values

| Name | Summary |
|---|---|
| [BYTE](-b-y-t-e.md) |  |
| [SHORT](-s-h-o-r-t.md) |  |
| [INTEGER](-i-n-t-e-g-e-r.md) |  |
| [LONG](-l-o-n-g.md) |  |
| [CHARACTER](-c-h-a-r-a-c-t-e-r.md) |  |
| [FLOAT](-f-l-o-a-t.md) |  |
| [DOUBLE](-d-o-u-b-l-e.md) |  |
| [BOOLEAN](-b-o-o-l-e-a-n.md) |  |

### Functions

| Name | Summary |
|---|---|
| [compare](compare.md) | `static fun compare(primary: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!>!, secondary: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!>!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Compares two class arrays on equivalence |
| [fromClass](from-class.md) | `static fun fromClass(clazz: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!): `[`ReflectionUtils.DataType`](./index.md)`!`<br>Returns the data type with the given primitive/reference class |
| [getPrimitive](get-primitive.md) | `fun getPrimitive(): `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!`<br>Returns the primitive class of this data type`static fun getPrimitive(clazz: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!): `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!`<br>Returns the primitive class of the data type with the given reference class`static fun getPrimitive(classes: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!>!): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!>!`<br>Returns the primitive class array of the given class array`static fun getPrimitive(objects: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>!): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!>!`<br>Returns the primitive class array of the given object array |
| [getReference](get-reference.md) | `fun getReference(): `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!`<br>Returns the reference class of this data type`static fun getReference(clazz: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!): `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!`<br>Returns the reference class of the data type with the given primitive class`static fun getReference(classes: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!>!): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!>!`<br>Returns the reference class array of the given class array`static fun getReference(objects: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>!): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!>!`<br>Returns the reference class array of the given object array |
