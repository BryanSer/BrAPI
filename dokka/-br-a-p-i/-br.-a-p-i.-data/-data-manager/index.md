[BrAPI](../../index.md) / [Br.API.Data](../index.md) / [DataManager](./index.md)

# DataManager

`abstract class DataManager`

**Author**
Bryan_lzh

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DataManager()` |

### Functions

| Name | Summary |
|---|---|
| [ForciblySave](-forcibly-save.md) | `open static fun ForciblySave(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>强制储存一个数据 |
| [getData](get-data.md) | `open static fun getData(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`DataService`](../-data-service/index.md)`!`<br>按指定字符串返回储存的数据(找不到将尝试读取)`open static fun getData(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!): `[`DataService`](../-data-service/index.md)`!`<br>按指定插件返回储存的数据(不会读取硬盘里的)  |
| [LoadAll](-load-all.md) | `open static fun LoadAll(rewrite: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [LoadData](-load-data.md) | `open static fun LoadData(plugin: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, rewrite: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [RegisterData](-register-data.md) | `open static fun RegisterData(ds: `[`DataService`](../-data-service/index.md)`!, p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`open static fun RegisterData(ds: `[`DataService`](../-data-service/index.md)`!, p: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>注册插件数据 |
| [SaveAll](-save-all.md) | `open static fun SaveAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toSafe](to-safe.md) | `open static fun toSafe(config: `[`FileConfiguration`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/configuration/file/FileConfiguration.html)`!): `[`FileConfiguration`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/configuration/file/FileConfiguration.html)`!` |
