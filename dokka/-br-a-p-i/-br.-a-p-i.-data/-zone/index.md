[BrAPI](../../index.md) / [Br.API.Data](../index.md) / [Zone](./index.md)

# Zone

`open class Zone : `[`BrConfigurationSerializable`](../-br-configuration-serializable/index.md)

**Author**
Bryan_lzh

**Version**
1.0

**Since**
2019-2-17

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Zone(top: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, bottom: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!)`<br>`Zone(args: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>!)` |

### Functions

| Name | Summary |
|---|---|
| [getBottom](get-bottom.md) | `open fun getBottom(): `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!` |
| [getTop](get-top.md) | `open fun getTop(): `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!` |
| [inZone](in-zone.md) | `open fun inZone(loc: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [setLocation](set-location.md) | `fun setLocation(l1: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, l2: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [serialize](../-br-configuration-serializable/serialize.md) | `open fun serialize(): `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>!` |
