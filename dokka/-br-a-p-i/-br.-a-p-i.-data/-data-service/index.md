[BrAPI](../../index.md) / [Br.API.Data](../index.md) / [DataService](./index.md)

# DataService

`interface DataService`

**Author**
Administrator

### Functions

| Name | Summary |
|---|---|
| [contains](contains.md) | `abstract fun contains(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [containsType](contains-type.md) | `abstract fun containsType(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, c: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<*>!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [get](get.md) | `abstract fun get(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!` |
| [getConfig](get-config.md) | `abstract fun ~~getConfig~~(): `[`YamlConfiguration`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/configuration/file/YamlConfiguration.html)`!` |
| [getKeySet](get-key-set.md) | `abstract fun getKeySet(): `[`MutableSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!>!` |
| [getPluginName](get-plugin-name.md) | `abstract fun getPluginName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [set](set.md) | `abstract fun set(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, o: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [EasyData](../-easy-data/index.md) | `open class EasyData : `[`DataService`](./index.md) |
| [SuperData](../-super-data/index.md) | `open class SuperData : `[`DataService`](./index.md) |
