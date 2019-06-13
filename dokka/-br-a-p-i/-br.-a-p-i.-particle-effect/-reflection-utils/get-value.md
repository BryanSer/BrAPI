[BrAPI](../../index.md) / [Br.API.ParticleEffect](../index.md) / [ReflectionUtils](index.md) / [getValue](./get-value.md)

# getValue

`static fun getValue(instance: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!, clazz: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!, declared: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!`

Returns the value of a field of the given class of an object

### Parameters

`instance` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: Target object

`clazz` - [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;!: Target class

`declared` - [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html): Whether the desired field is declared or not

`fieldName` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired field

### Exceptions

`IllegalArgumentException` - If the target object does not feature the desired field

`IllegalAccessException` - If the desired field cannot be accessed

`NoSuchFieldException` - If the desired field of the target class cannot be found

`SecurityException` - If the desired field cannot be made accessible

**Return**
[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: The value of field of the target object

**See Also**
[#getField(Class, boolean, String)](get-field.md)

`static fun getValue(instance: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!, className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, packageType: `[`ReflectionUtils.PackageType`](-package-type/index.md)`!, declared: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!`

Returns the value of a field of a desired class of an object

### Parameters

`instance` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: Target object

`className` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired target class

`packageType` - [ReflectionUtils.PackageType](-package-type/index.md)!: Package where the desired target class is located

`declared` - [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html): Whether the desired field is declared or not

`fieldName` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired field

### Exceptions

`IllegalArgumentException` - If the target object does not feature the desired field

`IllegalAccessException` - If the desired field cannot be accessed

`NoSuchFieldException` - If the desired field of the desired class cannot be found

`SecurityException` - If the desired field cannot be made accessible

`ClassNotFoundException` - If the desired target class with the specified name and package cannot be found

**Return**
[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: The value of field of the target object

**See Also**
[#getValue(Object, Class, boolean, String)](./get-value.md)

`static fun getValue(instance: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!, declared: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!`

Returns the value of a field with the given name of an object

### Parameters

`instance` - [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: Target object

`declared` - [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html): Whether the desired field is declared or not

`fieldName` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: Name of the desired field

### Exceptions

`IllegalArgumentException` - If the target object does not feature the desired field (should not occur since it searches for a field with the given name in the class of the object)

`IllegalAccessException` - If the desired field cannot be accessed

`NoSuchFieldException` - If the desired field of the target object cannot be found

`SecurityException` - If the desired field cannot be made accessible

**Return**
[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)!: The value of field of the target object

**See Also**
[#getValue(Object, Class, boolean, String)](./get-value.md)

