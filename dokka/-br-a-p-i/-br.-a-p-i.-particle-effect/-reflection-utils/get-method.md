[BrAPI](../../index.md) / [Br.API.ParticleEffect](../index.md) / [ReflectionUtils](index.md) / [getMethod](./get-method.md)

# getMethod

`static fun getMethod(clazz: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!, methodName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, vararg parameterTypes: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!): `[`Method`](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html)`!`

Returns a method of a class with the given parameter types

### Parameters

`clazz` - [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!: Target class

`methodName` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired method

`parameterTypes` - [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!: Parameter types of the desired method

### Exceptions

`NoSuchMethodException` - If the desired method of the target class with the specified name and parameter types cannot be found

**Return**
[Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html)!: The method of the target class with the specified name and parameter types

**See Also**
[DataType#getPrimitive(Class[])](-data-type/get-primitive.md)[DataType#compare(Class[], Class[])](-data-type/compare.md)

`static fun getMethod(className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, packageType: `[`ReflectionUtils.PackageType`](-package-type/index.md)`!, methodName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, vararg parameterTypes: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!): `[`Method`](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html)`!`

Returns a method of a desired class with the given parameter types

### Parameters

`className` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired target class

`packageType` - [ReflectionUtils.PackageType](-package-type/index.md)!: Package where the desired target class is located

`methodName` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired method

`parameterTypes` - [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!: Parameter types of the desired method

### Exceptions

`NoSuchMethodException` - If the desired method of the desired target class with the specified name and parameter types cannot be found

`ClassNotFoundException` - If the desired target class with the specified name and package cannot be found

**Return**
[Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html)!: The method of the desired target class with the specified name and parameter types

**See Also**
[PackageType#getClass(String)](-package-type/get-class.md)[#getMethod(Class, String, Class...)](./get-method.md)

