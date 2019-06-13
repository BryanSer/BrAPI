[BrAPI](../../../index.md) / [Br.API.Data](../../index.md) / [BrConfigurationSerializable](../index.md) / [MapTarget](./index.md)

# MapTarget

`@Target([AnnotationTarget.FIELD]) class ~~MapTarget~~`
**Deprecated:** Deprecated in Java

### Types

| Name | Summary |
|---|---|
| [KeyTypes](-key-types/index.md) | `class KeyTypes` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MapTarget(KeyType: `[`BrConfigurationSerializable.MapTarget.KeyTypes`](-key-types/index.md)`, KeyClass: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<*>, toObject: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, toStringMethod: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [KeyClass](-key-class.md) | `val KeyClass: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<*>`<br>若KeyType == Custom 将需要定义 |
| [KeyType](-key-type.md) | `val KeyType: `[`BrConfigurationSerializable.MapTarget.KeyTypes`](-key-types/index.md) |
| [toObject](to-object.md) | `val toObject: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>若KeyType == Custom 将需要定义 |
| [toStringMethod](to-string-method.md) | `val toStringMethod: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>若KeyType == Custom 将需要定义 |
