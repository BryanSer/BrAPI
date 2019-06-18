[BrAPI](../../index.md) / [com.github.bryanser.brapi](../index.md) / [Utils](index.md) / [saveResource](./save-resource.md)

# saveResource

`@JvmStatic fun saveResource(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`, res: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, fold: `[`File`](https://docs.oracle.com/javase/8/docs/api/java/io/File.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/BryanSer/BrAPI/blob/ver-kotlin/src/main/kotlin/com/github/bryanser/brapi/Utils.kt#L74)

数据插件jar里的文件

### Parameters

`p` - 插件

`res` - 资源文件名 如config.yml

`fold` - 目标文件夹 若为null则默认插件配置文件夹

### Exceptions

`IOException` - 