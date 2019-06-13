[BrAPI](../../index.md) / [Br.API.Data](../index.md) / [DatabaseSerializable](./index.md)

# DatabaseSerializable

`interface DatabaseSerializable`

使用该接口，可以超快捷实现对象在数据库中的序列化与反序列化

**Author**
Bryan_lzh

### Types

| Name | Summary |
|---|---|
| [PreparedStatements](-prepared-statements/index.md) | `open class PreparedStatements` |

### Annotations

| Name | Summary |
|---|---|
| [Config](-config/index.md) | `class Config` |
| [Database](-database/index.md) | `class Database` |

### Functions

| Name | Summary |
|---|---|
| [Bytes2Object](-bytes2-object.md) | `open static fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!> Bytes2Object(b: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`!, cls: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<out `[`T`](-bytes2-object.md#T)`>!): `[`T`](-bytes2-object.md#T) |
| [CreateTables](-create-tables.md) | `open static fun CreateTables(cls: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<out `[`DatabaseSerializable`](./index.md)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [Delete](-delete.md) | `open fun Delete(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [DeleteTable](-delete-table.md) | `open fun DeleteTable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [Deserialize](-deserialize.md) | `open static fun <T : `[`DatabaseSerializable`](./index.md)`!> Deserialize(key: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!, cls: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<`[`T`](-deserialize.md#T)`>!): `[`Optional`](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html)`<`[`T`](-deserialize.md#T)`>!`<br>`open static fun <T : `[`DatabaseSerializable`](./index.md)`!> ~~Deserialize~~(key: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!, t: `[`T`](-deserialize.md#T)`): `[`Optional`](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html)`<`[`T`](-deserialize.md#T)`>!` |
| [DeserializeAll](-deserialize-all.md) | `open static fun <T : `[`DatabaseSerializable`](./index.md)`!> DeserializeAll(cls: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<out `[`T`](-deserialize-all.md#T)`>!): `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`T`](-deserialize-all.md#T)`>!` |
| [getKey](get-key.md) | `open fun getKey(): `[`Field`](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html)`!`<br>`open static fun <T : `[`DatabaseSerializable`](./index.md)`!> getKey(cls: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<out `[`DatabaseSerializable`](./index.md)`!>!): `[`Field`](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html)`!` |
| [getKeyName](get-key-name.md) | `open fun getKeyName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [getLastLoad](get-last-load.md) | `abstract fun getLastLoad(): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [getObject](get-object.md) | `open static fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!> getObject(sr: `[`ResultSet`](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)`!, index: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, cls: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<out `[`T`](get-object.md#T)`>!): `[`T`](get-object.md#T)<br>`open static fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!> getObject(sr: `[`ResultSet`](https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html)`!, index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, cls: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<out `[`T`](get-object.md#T)`>!): `[`T`](get-object.md#T) |
| [getTableName](get-table-name.md) | `open fun getTableName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [isExists](is-exists.md) | `open fun isExists(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [Object2Bytes](-object2-bytes.md) | `open static fun Object2Bytes(obj: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`!` |
| [RecrateTable](-recrate-table.md) | `open fun RecrateTable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [Register](-register.md) | `open static fun Register(cls: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<out `[`DatabaseSerializable`](./index.md)`!>!, url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [Save](-save.md) | `open fun Save(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>储存对象 现已使用PreparedStatement |
| [setLastLoad](set-last-load.md) | `abstract fun setLastLoad(l: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [UpdateData](-update-data.md) | `open fun UpdateData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
