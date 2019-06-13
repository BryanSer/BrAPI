[BrAPI](../../index.md) / [Br.API.Commands](../index.md) / [SubCommandExecutor](index.md) / [onCommand](./on-command.md)

# onCommand

`abstract fun onCommand(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`!, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!>!, lable: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

### Parameters

`sender` - [CommandSender](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)!:

`args` - [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!&gt;!: args[0]不包括子命令名

`lable` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: 