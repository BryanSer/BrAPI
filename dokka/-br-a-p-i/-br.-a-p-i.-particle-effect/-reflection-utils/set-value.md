[BrAPI](../../index.md) / [Br.API.ParticleEffect](../index.md) / [ReflectionUtils](index.md) / [setValue](./set-value.md)

# setValue

`static fun setValue(instance: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!, clazz: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!, declared: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, value: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sets the value of a field of the given class of an object

### Parameters

`instance` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: Target object

`clazz` - [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!: Target class

`declared` - [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html): Whether the desired field is declared or not

`fieldName` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired field

`value` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: New value

### Exceptions

`IllegalArgumentException` - If the type of the value does not match the type of the desired field

`IllegalAccessException` - If the desired field cannot be accessed

`NoSuchFieldException` - If the desired field of the target class cannot be found

`SecurityException` - If the desired field cannot be made accessible

**See Also**
[#getField(Class, boolean, String)](get-field.md)

`static fun setValue(instance: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!, className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, packageType: `[`ReflectionUtils.PackageType`](-package-type/index.md)`!, declared: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, value: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sets the value of a field of a desired class of an object

### Parameters

`instance` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: Target object

`className` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired target class

`packageType` - [ReflectionUtils.PackageType](-package-type/index.md)!: Package where the desired target class is located

`declared` - [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html): Whether the desired field is declared or not

`fieldName` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired field

`value` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: New value

### Exceptions

`IllegalArgumentException` - If the type of the value does not match the type of the desired field

`IllegalAccessException` - If the desired field cannot be accessed

`NoSuchFieldException` - If the desired field of the desired class cannot be found

`SecurityException` - If the desired field cannot be made accessible

`ClassNotFoundException` - If the desired target class with the specified name and package cannot be found

**See Also**
[#setValue(Object, Class, boolean, String, Object)](./set-value.md)

`static fun setValue(instance: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!, declared: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, value: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sets the value of a field with the given name of an object

### Parameters

`instance` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: Target object

`declared` - [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html): Whether the desired field is declared or not

`fieldName` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired field

`value` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: New value

### Exceptions

`IllegalArgumentException` - If the type of the value does not match the type of the desired field

`IllegalAccessException` - If the desired field cannot be accessed

`NoSuchFieldException` - If the desired field of the target object cannot be found

`SecurityException` - If the desired field cannot be made accessible

**See Also**
[#setValue(Object, Class, boolean, String, Object)](./set-value.md)

