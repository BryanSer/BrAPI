[BrAPI](../../index.md) / [Br.API.ParticleEffect](../index.md) / [ReflectionUtils](index.md) / [getConstructor](./get-constructor.md)

# getConstructor

`static fun getConstructor(clazz: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!, vararg parameterTypes: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!): `[`Constructor`](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html)`<*>!`

Returns the constructor of a given class with the given parameter types

### Parameters

`clazz` - [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!: Target class

`parameterTypes` - [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!: Parameter types of the desired constructor

### Exceptions

`NoSuchMethodException` - If the desired constructor with the specified parameter types cannot be found

**Return**
[Constructor](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html)&lt;*&gt;!: The constructor of the target class with the specified parameter types

**See Also**
[DataType](-data-type/index.md)[DataType#getPrimitive(Class[])](-data-type/get-primitive.md)[DataType#compare(Class[], Class[])](-data-type/compare.md)

`static fun getConstructor(className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, packageType: `[`ReflectionUtils.PackageType`](-package-type/index.md)`!, vararg parameterTypes: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!): `[`Constructor`](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html)`<*>!`

Returns the constructor of a desired class with the given parameter types

### Parameters

`className` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired target class

`packageType` - [ReflectionUtils.PackageType](-package-type/index.md)!: Package where the desired target class is located

`parameterTypes` - [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!: Parameter types of the desired constructor

### Exceptions

`NoSuchMethodException` - If the desired constructor with the specified parameter types cannot be found

`ClassNotFoundException` - ClassNotFoundException If the desired target class with the specified name and package cannot be found

**Return**
[Constructor](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html)&lt;*&gt;!: The constructor of the desired target class with the specified parameter types

**See Also**
[PackageType#getClass(String)](-package-type/get-class.md)[#getConstructor(Class, Class...)](./get-constructor.md)

