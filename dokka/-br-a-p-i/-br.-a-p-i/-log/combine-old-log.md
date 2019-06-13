[BrAPI](../../index.md) / [Br.API](../index.md) / [Log](index.md) / [combineOldLog](./combine-old-log.md)

# combineOldLog

`open static fun combineOldLog(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, c: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Log`](index.md)`!`

将旧的.\\Log\\文件夹里的全部xxx.log合并到.\Log.log中 并且创建一个单独文件作为log的对象

### Parameters

`p` - [Plugin](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)!: 插件主类

`c` - [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): 缓存空间

**Return**
[Log](index.md)!:

`open static fun combineOldLog(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, c: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, con: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Log`](index.md)`!`

将旧的.\\Log\\文件夹里的全部xxx.log合并到.\Log.log中 并且创建一个单独文件作为log的对象

### Parameters

`p` - [Plugin](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)!: 插件主类

`c` - [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): 缓存空间

`con` - [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html): 是否向后台输出

**Return**
[Log](index.md)!:

