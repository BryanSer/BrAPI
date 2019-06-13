[BrAPI](../../index.md) / [Br.API.Data](../index.md) / [DataManager](index.md) / [getData](./get-data.md)

# getData

`open static fun getData(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`DataService`](../-data-service/index.md)`!`

按指定字符串返回储存的数据(找不到将尝试读取)

### Parameters

`s` - [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!:

**Return**
[DataService](../-data-service/index.md)!: DataService

`open static fun getData(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!): `[`DataService`](../-data-service/index.md)`!`

按指定插件返回储存的数据(不会读取硬盘里的)

 与getData(p.getName())相同意义

### Parameters

`p` - [Plugin](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)!:

**Return**
[DataService](../-data-service/index.md)!: DataService

