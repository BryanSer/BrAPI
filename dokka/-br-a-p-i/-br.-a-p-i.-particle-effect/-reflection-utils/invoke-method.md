[BrAPI](../../index.md) / [Br.API.ParticleEffect](../index.md) / [ReflectionUtils](index.md) / [invokeMethod](./invoke-method.md)

# invokeMethod

`static fun invokeMethod(instance: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!, methodName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, vararg arguments: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!`

Invokes a method on an object with the given arguments

### Parameters

`instance` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: Target object

`methodName` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired method

`arguments` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: Arguments which are used to invoke the desired method

### Exceptions

`IllegalAccessException` - If the desired method cannot be accessed due to certain circumstances

`IllegalArgumentException` - If the types of the arguments do not match the parameter types of the method (this should not occur since it searches for a method with the types of the arguments)

`InvocationTargetException` - If the desired method cannot be invoked on the target object

`NoSuchMethodException` - If the desired method of the class of the target object with the specified name and arguments cannot be found

**Return**
[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: The result of invoking the desired method on the target object

**See Also**
[#getMethod(Class, String, Class...)](get-method.md)[DataType#getPrimitive(Object[])](-data-type/get-primitive.md)

`static fun invokeMethod(instance: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!, clazz: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!, methodName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, vararg arguments: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!`

Invokes a method of the target class on an object with the given arguments

### Parameters

`instance` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: Target object

`clazz` - [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!: Target class

`methodName` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired method

`arguments` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: Arguments which are used to invoke the desired method

### Exceptions

`IllegalAccessException` - If the desired method cannot be accessed due to certain circumstances

`IllegalArgumentException` - If the types of the arguments do not match the parameter types of the method (this should not occur since it searches for a method with the types of the arguments)

`InvocationTargetException` - If the desired method cannot be invoked on the target object

`NoSuchMethodException` - If the desired method of the target class with the specified name and arguments cannot be found

**Return**
[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: The result of invoking the desired method on the target object

**See Also**
[#getMethod(Class, String, Class...)](get-method.md)[DataType#getPrimitive(Object[])](-data-type/get-primitive.md)

`static fun invokeMethod(instance: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!, className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, packageType: `[`ReflectionUtils.PackageType`](-package-type/index.md)`!, methodName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, vararg arguments: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!`

Invokes a method of a desired class on an object with the given arguments

### Parameters

`instance` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: Target object

`className` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired target class

`packageType` - [ReflectionUtils.PackageType](-package-type/index.md)!: Package where the desired target class is located

`methodName` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired method

`arguments` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: Arguments which are used to invoke the desired method

### Exceptions

`IllegalAccessException` - If the desired method cannot be accessed due to certain circumstances

`IllegalArgumentException` - If the types of the arguments do not match the parameter types of the method (this should not occur since it searches for a method with the types of the arguments)

`InvocationTargetException` - If the desired method cannot be invoked on the target object

`NoSuchMethodException` - If the desired method of the desired target class with the specified name and arguments cannot be found

`ClassNotFoundException` - If the desired target class with the specified name and package cannot be found

**Return**
[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: The result of invoking the desired method on the target object

**See Also**
[PackageType#getClass(String)](-package-type/get-class.md)[#invokeMethod(Object, Class, String, Object...)](./invoke-method.md)

