[BrAPI](../../index.md) / [Br.API.Data](../index.md) / [BrConfigurationSerializableV2](./index.md)

# BrConfigurationSerializableV2

`interface BrConfigurationSerializableV2 : `[`ConfigurationSerializable`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/configuration/serialization/ConfigurationSerializable.html)

用于快捷实现ConfigurationSerializable

**Author**
Bryan_lzh

### Annotations

| Name | Summary |
|---|---|
| [Config](-config/index.md) | `class Config`<br>带有该注释的局域变量将会自动被序列化 |

### Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | `open static fun <T : `[`BrConfigurationSerializableV2`](./index.md)`!> deserialize(args: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>!, t: `[`T`](deserialize.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>自动反序列号静态方法 |
| [getAllDeclaredFields](get-all-declared-fields.md) | `open static fun <T : `[`BrConfigurationSerializableV2`](./index.md)`!> getAllDeclaredFields(cls: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<`[`T`](get-all-declared-fields.md#T)`>!): `[`MutableCollection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-collection/index.html)`<`[`Field`](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html)`!>!` |
| [serialize](serialize.md) | `open fun serialize(): `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>!` |
