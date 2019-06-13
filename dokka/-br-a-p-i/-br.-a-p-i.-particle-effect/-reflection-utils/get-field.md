[BrAPI](../../index.md) / [Br.API.ParticleEffect](../index.md) / [ReflectionUtils](index.md) / [getField](./get-field.md)

# getField

`static fun getField(clazz: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!, declared: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Field`](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html)`!`

Returns a field of the target class with the given name

### Parameters

`clazz` - [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!: Target class

`declared` - [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html): Whether the desired field is declared or not

`fieldName` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired field

### Exceptions

`NoSuchFieldException` - If the desired field of the given class cannot be found

`SecurityException` - If the desired field cannot be made accessible

**Return**
[Field](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html)!: The field of the target class with the specified name

`static fun getField(className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, packageType: `[`ReflectionUtils.PackageType`](-package-type/index.md)`!, declared: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Field`](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html)`!`

Returns a field of a desired class with the given name

### Parameters

`className` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired target class

`packageType` - [ReflectionUtils.PackageType](-package-type/index.md)!: Package where the desired target class is located

`declared` - [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html): Whether the desired field is declared or not

`fieldName` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired field

### Exceptions

`NoSuchFieldException` - If the desired field of the desired class cannot be found

`SecurityException` - If the desired field cannot be made accessible

`ClassNotFoundException` - If the desired target class with the specified name and package cannot be found

**Return**
[Field](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html)!: The field of the desired target class with the specified name

**See Also**
[#getField(Class, boolean, String)](./get-field.md)

