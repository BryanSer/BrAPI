[BrAPI](../../index.md) / [Br.API.Commands](../index.md) / [SubCommand](./index.md)

# SubCommand

`@Target([AnnotationTarget.FIELD]) class SubCommand`

**Author**
Bryan_lzh

**Version**
1.0

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SubCommand(command: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, usage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, minimalArgs: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, argsNotEnough: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, permission: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [argsNotEnough](args-not-enough.md) | `val argsNotEnough: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [command](command.md) | `val command: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [minimalArgs](minimal-args.md) | `val minimalArgs: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>这个参数不包括子命令 也就是 如果玩家使用/command subcommand 那么参数是0 |
| [permission](permission.md) | `val permission: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [PERMISSION_NONE](-p-e-r-m-i-s-s-i-o-n_-n-o-n-e.md) | `static val PERMISSION_NONE: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [PERMISSION_OP](-p-e-r-m-i-s-s-i-o-n_-o-p.md) | `static val PERMISSION_OP: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [usage](usage.md) | `val usage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
