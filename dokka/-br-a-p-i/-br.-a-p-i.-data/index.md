[BrAPI](../index.md) / [Br.API.Data](./index.md)

## Package Br.API.Data

### Types

| Name | Summary |
|---|---|
| [BrConfigurationSerializable](-br-configuration-serializable/index.md) | `interface BrConfigurationSerializable : `[`ConfigurationSerializable`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/configuration/serialization/ConfigurationSerializable.html)<br>用于快捷实现ConfigurationSerializable |
| [BrConfigurationSerializableV2](-br-configuration-serializable-v2/index.md) | `interface BrConfigurationSerializableV2 : `[`ConfigurationSerializable`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/configuration/serialization/ConfigurationSerializable.html)<br>用于快捷实现ConfigurationSerializable |
| [ConfigHelper](-config-helper/index.md) | `abstract class ConfigHelper` |
| [DatabaseSerializable](-database-serializable/index.md) | `interface DatabaseSerializable`<br>使用该接口，可以超快捷实现对象在数据库中的序列化与反序列化 |
| [DataManager](-data-manager/index.md) | `abstract class DataManager` |
| [DataService](-data-service/index.md) | `interface DataService` |
| [EasyData](-easy-data/index.md) | `open class EasyData : `[`DataService`](-data-service/index.md) |
| [ProxyUtil](-proxy-util/index.md) | `interface ProxyUtil` |
| [SuperData](-super-data/index.md) | `open class SuperData : `[`DataService`](-data-service/index.md) |
| [Zone](-zone/index.md) | `open class Zone : `[`BrConfigurationSerializable`](-br-configuration-serializable/index.md) |

### Exceptions

| Name | Summary |
|---|---|
| [NullDatabaseNameException](-null-database-name-exception/index.md) | `open class NullDatabaseNameException : `[`Exception`](https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html) |
| [NullKeyException](-null-key-exception/index.md) | `open class NullKeyException : `[`Exception`](https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html) |
| [TooMuchKeyException](-too-much-key-exception/index.md) | `open class TooMuchKeyException : `[`Exception`](https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html) |
