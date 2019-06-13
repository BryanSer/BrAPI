[BrAPI](../../index.md) / [Br.API](../index.md) / [Log](index.md) / [getOneFileLog](./get-one-file-log.md)

# getOneFileLog

`open static fun getOneFileLog(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, cache: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Log`](index.md)`!`

创建一个单独文件作为log的对象

### Parameters

`p` - [Plugin](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)!: 插件主类

`cache` - [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): 缓存空间 建议填写1这样能实时生成log

**Return**
[Log](index.md)!:

`open static fun getOneFileLog(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, c: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, con: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Log`](index.md)`!`

创建一个单独文件作为log的对象

### Parameters

`p` - [Plugin](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)!: 插件主类

`c` - [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): 缓存空间

`con` - [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html): 是否向后台输出内容

**Return**
[Log](index.md)!:

