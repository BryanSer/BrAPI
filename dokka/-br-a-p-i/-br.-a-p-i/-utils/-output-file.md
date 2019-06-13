[BrAPI](../../index.md) / [Br.API](../index.md) / [Utils](index.md) / [OutputFile](./-output-file.md)

# OutputFile

`open static fun OutputFile(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, res: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, fold: `[`File`](https://docs.oracle.com/javase/8/docs/api/java/io/File.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

数据插件jar里的文件

### Parameters

`p` - [Plugin](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)!: 插件

`res` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!: 资源文件名 如config.yml

`fold` - [File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html)!: 目标文件夹 若为null则默认插件配置文件夹

### Exceptions

`IOException` - 