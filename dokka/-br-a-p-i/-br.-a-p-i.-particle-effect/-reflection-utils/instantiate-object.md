[BrAPI](../../index.md) / [Br.API.ParticleEffect](../index.md) / [ReflectionUtils](index.md) / [instantiateObject](./instantiate-object.md)

# instantiateObject

`static fun instantiateObject(clazz: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!, vararg arguments: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!`

Returns an instance of a class with the given arguments

### Parameters

`clazz` - [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!: Target class

`arguments` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: Arguments which are used to construct an object of the target class

### Exceptions

`InstantiationException` - If you cannot create an instance of the target class due to certain circumstances

`IllegalAccessException` - If the desired constructor cannot be accessed due to certain circumstances

`IllegalArgumentException` - If the types of the arguments do not match the parameter types of the constructor (this should not occur since it searches for a constructor with the types of the arguments)

`InvocationTargetException` - If the desired constructor cannot be invoked

`NoSuchMethodException` - If the desired constructor with the specified arguments cannot be found

**Return**
[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: The instance of the target class with the specified arguments

`static fun instantiateObject(className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, packageType: `[`ReflectionUtils.PackageType`](-package-type/index.md)`!, vararg arguments: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!`

Returns an instance of a desired class with the given arguments

### Parameters

`className` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired target class

`packageType` - [ReflectionUtils.PackageType](-package-type/index.md)!: Package where the desired target class is located

`arguments` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: Arguments which are used to construct an object of the desired target class

### Exceptions

`InstantiationException` - If you cannot create an instance of the desired target class due to certain circumstances

`IllegalAccessException` - If the desired constructor cannot be accessed due to certain circumstances

`IllegalArgumentException` - If the types of the arguments do not match the parameter types of the constructor (this should not occur since it searches for a constructor with the types of the arguments)

`InvocationTargetException` - If the desired constructor cannot be invoked

`NoSuchMethodException` - If the desired constructor with the specified arguments cannot be found

`ClassNotFoundException` - If the desired target class with the specified name and package cannot be found

**Return**
[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: The instance of the desired target class with the specified arguments

**See Also**
[PackageType#getClass(String)](-package-type/get-class.md)[#instantiateObject(Class, Object...)](./instantiate-object.md)

