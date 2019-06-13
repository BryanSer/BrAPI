[BrAPI](../../index.md) / [Br.API.Data](../index.md) / [ProxyUtil](./index.md)

# ProxyUtil

`interface ProxyUtil`

**Author**
Bryan_lzh

**Version**
1.0

**Since**
2018-9-3

### Types

| Name | Summary |
|---|---|
| [ProxiedScript](-proxied-script/index.md) | `interface ProxiedScript<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>` |
| [Util](-util/index.md) | `open class Util` |

### Annotations

| Name | Summary |
|---|---|
| [Proxy](-proxy/index.md) | `class Proxy`<br>被代理对象的标识 |
| [ProxyInfo](-proxy-info/index.md) | `class ProxyInfo` |
| [ProxyScript](-proxy-script/index.md) | `class ProxyScript` |

### Properties

| Name | Summary |
|---|---|
| [Proxied](-proxied.md) | `static val Proxied: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<out `[`ProxyUtil`](./index.md)`!>!>!>!` |

### Functions

| Name | Summary |
|---|---|
| [addProxy](add-proxy.md) | `open static fun addProxy(plugin: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, cls: `[`Class`](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<out `[`ProxyUtil`](./index.md)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [proxy](proxy.md) | `open static fun proxy(plugin: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
