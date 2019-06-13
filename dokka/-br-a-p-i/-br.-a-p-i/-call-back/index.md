[BrAPI](../../index.md) / [Br.API](../index.md) / [CallBack](./index.md)

# CallBack

`open class CallBack : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)

**Author**
Bryan_lzh

**Version**
1.0

### Types

| Name | Summary |
|---|---|
| [ButtonInfo](-button-info/index.md) | `open class ButtonInfo : `[`BukkitRunnable`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/scheduler/BukkitRunnable.html) |
| [InputInfo](-input-info/index.md) | `open class InputInfo : `[`BukkitRunnable`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/scheduler/BukkitRunnable.html) |

### Functions

| Name | Summary |
|---|---|
| [cancelButtonRequest](cancel-button-request.md) | `open static fun cancelButtonRequest(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getButton](get-button.md) | `open static fun getButton(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, cmd: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<BaseComponent!>!` |
| [onChat](on-chat.md) | `open fun onChat(evt: `[`AsyncPlayerChatEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/AsyncPlayerChatEvent.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCommand](on-command.md) | `open fun onCommand(evt: `[`PlayerCommandPreprocessEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerCommandPreprocessEvent.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [RegisterListener](-register-listener.md) | `open static fun RegisterListener(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [SendButtonRequest](-send-button-request.md) | `open static fun ~~SendButtonRequest~~(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, msg: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!>!, callback: `[`BiConsumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`!>!, overtime: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [sendButtonRequest](send-button-request.md) | `open static fun sendButtonRequest(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, msg: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!>!, callback: `[`BiConsumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`!>!, overtime: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>向玩家发送一堆按钮 按钮的的内容将由msg决定,最后通过BiConsumer来返回执行玩家按下的按钮`open static fun sendButtonRequest(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, msg: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!>!, callback: `[`BiConsumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`!>!, overtime: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, format: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [sendInputRequest](send-input-request.md) | `open static fun sendInputRequest(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, callback: `[`BiConsumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!>!, overtime: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [SendSignRequest](-send-sign-request.md) | `open static fun ~~SendSignRequest~~(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, callback: `[`BiConsumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sendSignRequest](send-sign-request.md) | `open static fun sendSignRequest(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, callback: `[`BiConsumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
