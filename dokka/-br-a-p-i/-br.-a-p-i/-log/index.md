[BrAPI](../../index.md) / [Br.API](../index.md) / [Log](./index.md)

# Log

`open class Log : `[`Writer`](https://docs.oracle.com/javase/8/docs/api/java/io/Writer.html)

**Author**
Bryan_lzh

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Log(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, deleteday: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, cachelength: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)`<br>`Log(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, deleteday: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, cachelength: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, con: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)` |

### Functions

| Name | Summary |
|---|---|
| [close](close.md) | `open fun close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [CombineOldLog](-combine-old-log.md) | `open static fun ~~CombineOldLog~~(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, c: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Log`](./index.md)`!`<br>`open static fun ~~CombineOldLog~~(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, c: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, con: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Log`](./index.md)`!` |
| [combineOldLog](combine-old-log.md) | `open static fun combineOldLog(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, c: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Log`](./index.md)`!`<br>`open static fun combineOldLog(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, c: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, con: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Log`](./index.md)`!`<br>将旧的.\\Log\\文件夹里的全部xxx.log合并到.\Log.log中 并且创建一个单独文件作为log的对象 |
| [flush](flush.md) | `open fun flush(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getDate](get-date.md) | `open fun getDate(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [getOneFileLog](get-one-file-log.md) | `open static fun getOneFileLog(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, cache: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Log`](./index.md)`!`<br>`open static fun getOneFileLog(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, c: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, con: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Log`](./index.md)`!`<br>创建一个单独文件作为log的对象 |
| [getTime](get-time.md) | `open fun getTime(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!` |
| [log](log.md) | `open fun log(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [Log](-log.md) | `open fun ~~Log~~(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [logRaw](log-raw.md) | `open fun logRaw(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [LogRaw](-log-raw.md) | `open fun ~~LogRaw~~(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [save](save.md) | `open fun save(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [Save](-save.md) | `open fun ~~Save~~(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toPrintWriter](to-print-writer.md) | `open fun toPrintWriter(): `[`PrintWriter`](https://docs.oracle.com/javase/8/docs/api/java/io/PrintWriter.html)`!` |
| [write](write.md) | `open fun write(cbuf: `[`CharArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-array/index.html)`!, off: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, len: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
