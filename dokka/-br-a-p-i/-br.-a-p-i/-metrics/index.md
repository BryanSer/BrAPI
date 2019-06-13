[BrAPI](../../index.md) / [Br.API](../index.md) / [Metrics](./index.md)

# Metrics

`open class Metrics`

bStats collects some data for plugin authors. Check out https://bStats.org/ to learn more about bStats!

### Types

| Name | Summary |
|---|---|
| [AdvancedBarChart](-advanced-bar-chart/index.md) | `open class AdvancedBarChart : `[`Metrics.CustomChart`](-custom-chart/index.md)<br>Represents a custom advanced bar chart. |
| [AdvancedPie](-advanced-pie/index.md) | `open class AdvancedPie : `[`Metrics.CustomChart`](-custom-chart/index.md)<br>Represents a custom advanced pie. |
| [CustomChart](-custom-chart/index.md) | `abstract class CustomChart`<br>Represents a custom chart. |
| [DrilldownPie](-drilldown-pie/index.md) | `open class DrilldownPie : `[`Metrics.CustomChart`](-custom-chart/index.md)<br>Represents a custom drilldown pie. |
| [MultiLineChart](-multi-line-chart/index.md) | `open class MultiLineChart : `[`Metrics.CustomChart`](-custom-chart/index.md)<br>Represents a custom multi line chart. |
| [SimpleBarChart](-simple-bar-chart/index.md) | `open class SimpleBarChart : `[`Metrics.CustomChart`](-custom-chart/index.md)<br>Represents a custom simple bar chart. |
| [SimplePie](-simple-pie/index.md) | `open class SimplePie : `[`Metrics.CustomChart`](-custom-chart/index.md)<br>Represents a custom simple pie. |
| [SingleLineChart](-single-line-chart/index.md) | `open class SingleLineChart : `[`Metrics.CustomChart`](-custom-chart/index.md)<br>Represents a custom single line chart. |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Metrics(plugin: `[`JavaPlugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/java/JavaPlugin.html)`!)`<br>Class constructor. |

### Properties

| Name | Summary |
|---|---|
| [B_STATS_VERSION](-b_-s-t-a-t-s_-v-e-r-s-i-o-n.md) | `static val B_STATS_VERSION: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [addCustomChart](add-custom-chart.md) | `open fun addCustomChart(chart: `[`Metrics.CustomChart`](-custom-chart/index.md)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a custom chart. |
| [getPluginData](get-plugin-data.md) | `open fun getPluginData(): JSONObject!`<br>Gets the plugin specific data. This method is called using Reflection. |
