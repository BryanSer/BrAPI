[BrAPI](../../index.md) / [Br.API.Scripts](../index.md) / [ScriptListener](./index.md)

# ScriptListener

`interface ScriptListener<E : `[`Event`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Event.html)`!> : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)

**Author**
Bryan_lzh

**Version**
1.0

### Functions

| Name | Summary |
|---|---|
| [castEvent](cast-event.md) | `open fun castEvent(evt: `[`E`](index.md#E)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getEventClass](get-event-class.md) | `open fun getEventClass(): `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<`[`E`](index.md#E)`>!` |
| [getEventName](get-event-name.md) | `abstract fun getEventName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [getPriority](get-priority.md) | `open fun getPriority(): `[`EventPriority`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/EventPriority.html)`!` |
| [ignoreCancelled](ignore-cancelled.md) | `open fun ignoreCancelled(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onEvent](on-event.md) | `abstract fun onEvent(e: `[`E`](index.md#E)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
