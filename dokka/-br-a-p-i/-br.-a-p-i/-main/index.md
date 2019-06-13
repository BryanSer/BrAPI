[BrAPI](../../index.md) / [Br.API](../index.md) / [Main](./index.md)

# Main

`open class Main : `[`JavaPlugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/java/JavaPlugin.html)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Main()` |

### Properties

| Name | Summary |
|---|---|
| [Plugins](-plugins.md) | `static var Plugins: `[`MutableSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!>!` |
| [PluginsAmount](-plugins-amount.md) | `static var PluginsAmount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [onCommand](on-command.md) | `open fun onCommand(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`!, cmd: `[`Command`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/Command.html)`!, label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!>!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onDisable](on-disable.md) | `open fun onDisable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onEnable](on-enable.md) | `open fun onEnable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [RegisterMetrics](-register-metrics.md) | `open static fun RegisterMetrics(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
