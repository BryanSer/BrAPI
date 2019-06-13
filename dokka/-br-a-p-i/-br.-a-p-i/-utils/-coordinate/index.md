[BrAPI](../../../index.md) / [Br.API](../../index.md) / [Utils](../index.md) / [Coordinate](./index.md)

# Coordinate

`open class Coordinate`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Coordinate()` |

### Functions

| Name | Summary |
|---|---|
| [create2DProjector](create2-d-projector.md) | `open static fun create2DProjector(loc: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, n: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!): `[`BiFunction`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html)`<`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`!, `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`!, `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!>!`<br>创建二维→三维投影器 |
| [getLeft](get-left.md) | `open static fun getLeft(look: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!): `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!` |
| [getLookAtEntity](get-look-at-entity.md) | `open static fun getLookAtEntity(e: `[`LivingEntity`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/LivingEntity.html)`!, maxlength: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, ρ: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`LivingEntity`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/LivingEntity.html)`!` |
| [getRight](get-right.md) | `open static fun getRight(look: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!): `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!` |
| [toYawAndPitch](to-yaw-and-pitch.md) | `open static fun toYawAndPitch(v: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!): `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html)`!`<br>将向量转换为Location里使用的yaw与pitch |
