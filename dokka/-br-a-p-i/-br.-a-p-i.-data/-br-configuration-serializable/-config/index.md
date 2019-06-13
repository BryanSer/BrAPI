[BrAPI](../../../index.md) / [Br.API.Data](../../index.md) / [BrConfigurationSerializable](../index.md) / [Config](./index.md)

# Config

`@Target([AnnotationTarget.FIELD]) class Config`

带有该注释的局域变量将会自动被序列化

 如果注释的是Map请确保key的泛型为String

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Config(Path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>带有该注释的局域变量将会自动被序列化 |

### Properties

| Name | Summary |
|---|---|
| [Path](-path.md) | `val Path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>用于指定序列号后在TAML中的相对位置 默认为变量名 |
