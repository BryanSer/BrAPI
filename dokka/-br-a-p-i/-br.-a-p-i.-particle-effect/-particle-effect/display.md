[BrAPI](../../index.md) / [Br.API.ParticleEffect](../index.md) / [ParticleEffect](index.md) / [display](./display.md)

# display

`fun display(offsetX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetZ: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, range: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a particle effect which is only visible for all players within a certain range in the world of @param center

### Parameters

`offsetX` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the x-axis

`offsetY` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the y-axis

`offsetZ` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the z-axis

`speed` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Display speed of the particles

`amount` - [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): Amount of particles

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`range` - [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html): Range of the visibility

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleDataException` - If the particle effect requires additional data

`IllegalArgumentException` - If the particle effect requires water and none is at the center location

**See Also**
[ParticlePacket](-particle-packet/index.md)[ParticlePacket#sendTo(Location, double)](-particle-packet/send-to.md)

`fun display(offsetX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetZ: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a particle effect which is only visible for the specified players

### Parameters

`offsetX` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the x-axis

`offsetY` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the y-axis

`offsetZ` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the z-axis

`speed` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Display speed of the particles

`amount` - [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): Amount of particles

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`players` - [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!&gt;!: Receivers of the effect

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleDataException` - If the particle effect requires additional data

`IllegalArgumentException` - If the particle effect requires water and none is at the center location

**See Also**
[ParticlePacket](-particle-packet/index.md)[ParticlePacket#sendTo(Location, List)](-particle-packet/send-to.md)

`fun display(offsetX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetZ: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, vararg players: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a particle effect which is only visible for the specified players

### Parameters

`offsetX` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the x-axis

`offsetY` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the y-axis

`offsetZ` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the z-axis

`speed` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Display speed of the particles

`amount` - [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): Amount of particles

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`players` - [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!: Receivers of the effect

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleDataException` - If the particle effect requires additional data

`IllegalArgumentException` - If the particle effect requires water and none is at the center location

**See Also**
[#display(float, float, float, float, int, Location, List)](./display.md)

`fun display(direction: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, range: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a single particle which flies into a determined direction and is only visible for all players within a certain range in the world of

### Parameters

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`direction` - [Vector](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)!: Direction of the particle

`speed` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Display speed of the particle

`range` - [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html): Range of the visibility

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleDataException` - If the particle effect requires additional data

`IllegalArgumentException` - If the particle effect is not directional or if it requires water and none is at the center location

**See Also**
[ParticlePacket#ParticlePacket(ParticleEffect, Vector, float,
     * boolean, ParticleData)](-particle-packet/-init-.md)[ParticlePacket#sendTo(Location, double)](-particle-packet/send-to.md)

`fun display(direction: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a single particle which flies into a determined direction and is only visible for the specified players

### Parameters

`direction` - [Vector](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)!: Direction of the particle

`speed` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Display speed of the particle

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`players` - [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!&gt;!: Receivers of the effect

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleDataException` - If the particle effect requires additional data

`IllegalArgumentException` - If the particle effect is not directional or if it requires water and none is at the center location

**See Also**
[ParticlePacket#ParticlePacket(ParticleEffect, Vector, float,
     * boolean, ParticleData)](-particle-packet/-init-.md)[ParticlePacket#sendTo(Location, List)](-particle-packet/send-to.md)

`fun display(direction: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, vararg players: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a single particle which flies into a determined direction and is only visible for the specified players

### Parameters

`direction` - [Vector](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)!: Direction of the particle

`speed` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Display speed of the particle

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`players` - [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!: Receivers of the effect

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleDataException` - If the particle effect requires additional data

`IllegalArgumentException` - If the particle effect is not directional or if it requires water and none is at the center location

**See Also**
[#display(Vector, float, Location, List)](./display.md)

`fun display(color: `[`ParticleEffect.ParticleColor`](-particle-color/index.md)`!, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, range: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a single particle which is colored and only visible for all players within a certain range in the world of @param center

### Parameters

`color` - [ParticleEffect.ParticleColor](-particle-color/index.md)!: Color of the particle

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`range` - [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html): Range of the visibility

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleColorException` - If the particle effect is not colorable or the color type is incorrect

**See Also**
[ParticlePacket#ParticlePacket(ParticleEffect, ParticleColor,
     * boolean)](-particle-packet/-init-.md)[ParticlePacket#sendTo(Location, double)](-particle-packet/send-to.md)

`fun display(color: `[`ParticleEffect.ParticleColor`](-particle-color/index.md)`!, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a single particle which is colored and only visible for the specified players

### Parameters

`color` - [ParticleEffect.ParticleColor](-particle-color/index.md)!: Color of the particle

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`players` - [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!&gt;!: Receivers of the effect

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleColorException` - If the particle effect is not colorable or the color type is incorrect

**See Also**
[ParticlePacket#ParticlePacket(ParticleEffect, ParticleColor,
     * boolean)](-particle-packet/-init-.md)[ParticlePacket#sendTo(Location, List)](-particle-packet/send-to.md)

`fun display(color: `[`ParticleEffect.ParticleColor`](-particle-color/index.md)`!, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, vararg players: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a single particle which is colored and only visible for the specified players

### Parameters

`color` - [ParticleEffect.ParticleColor](-particle-color/index.md)!: Color of the particle

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`players` - [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!: Receivers of the effect

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleColorException` - If the particle effect is not colorable or the color type is incorrect

**See Also**
[#display(ParticleColor, Location, List)](./display.md)

`fun display(data: `[`ParticleEffect.ParticleData`](-particle-data/index.md)`!, offsetX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetZ: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, range: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a particle effect which requires additional data and is only visible for all players within a certain range in the world of @param center

### Parameters

`data` - [ParticleEffect.ParticleData](-particle-data/index.md)!: Data of the effect

`offsetX` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the x-axis

`offsetY` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the y-axis

`offsetZ` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the z-axis

`speed` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Display speed of the particles

`amount` - [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): Amount of particles

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`range` - [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html): Range of the visibility

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleDataException` - If the particle effect does not require additional data or if the data type is incorrect

**See Also**
[ParticlePacket](-particle-packet/index.md)[ParticlePacket#sendTo(Location, double)](-particle-packet/send-to.md)

`fun display(data: `[`ParticleEffect.ParticleData`](-particle-data/index.md)`!, offsetX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetZ: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a particle effect which requires additional data and is only visible for the specified players

### Parameters

`data` - [ParticleEffect.ParticleData](-particle-data/index.md)!: Data of the effect

`offsetX` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the x-axis

`offsetY` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the y-axis

`offsetZ` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the z-axis

`speed` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Display speed of the particles

`amount` - [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): Amount of particles

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`players` - [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!&gt;!: Receivers of the effect

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleDataException` - If the particle effect does not require additional data or if the data type is incorrect

**See Also**
[ParticlePacket](-particle-packet/index.md)[ParticlePacket#sendTo(Location, List)](-particle-packet/send-to.md)

`fun display(data: `[`ParticleEffect.ParticleData`](-particle-data/index.md)`!, offsetX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetZ: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, vararg players: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a particle effect which requires additional data and is only visible for the specified players

### Parameters

`data` - [ParticleEffect.ParticleData](-particle-data/index.md)!: Data of the effect

`offsetX` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the x-axis

`offsetY` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the y-axis

`offsetZ` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the z-axis

`speed` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Display speed of the particles

`amount` - [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): Amount of particles

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`players` - [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!: Receivers of the effect

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleDataException` - If the particle effect does not require additional data or if the data type is incorrect

**See Also**
[#display(ParticleData, float, float, float, float, int, Location,
     * List)](./display.md)

`fun display(data: `[`ParticleEffect.ParticleData`](-particle-data/index.md)`!, direction: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, range: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a single particle which requires additional data that flies into a determined direction and is only visible for all players within a certain range in the world of @param center

### Parameters

`data` - [ParticleEffect.ParticleData](-particle-data/index.md)!: Data of the effect

`direction` - [Vector](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)!: Direction of the particle

`speed` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Display speed of the particles

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`range` - [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html): Range of the visibility

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleDataException` - If the particle effect does not require additional data or if the data type is incorrect

**See Also**
[ParticlePacket](-particle-packet/index.md)[ParticlePacket#sendTo(Location, double)](-particle-packet/send-to.md)

`fun display(data: `[`ParticleEffect.ParticleData`](-particle-data/index.md)`!, direction: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a single particle which requires additional data that flies into a determined direction and is only visible for the specified players

### Parameters

`data` - [ParticleEffect.ParticleData](-particle-data/index.md)!: Data of the effect

`direction` - [Vector](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)!: Direction of the particle

`speed` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Display speed of the particles

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`players` - [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!&gt;!: Receivers of the effect

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleDataException` - If the particle effect does not require additional data or if the data type is incorrect

**See Also**
[ParticlePacket](-particle-packet/index.md)[ParticlePacket#sendTo(Location, List)](-particle-packet/send-to.md)

`fun display(data: `[`ParticleEffect.ParticleData`](-particle-data/index.md)`!, direction: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, vararg players: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Displays a single particle which requires additional data that flies into a determined direction and is only visible for the specified players

### Parameters

`data` - [ParticleEffect.ParticleData](-particle-data/index.md)!: Data of the effect

`direction` - [Vector](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)!: Direction of the particle

`speed` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Display speed of the particles

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`players` - [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!: Receivers of the effect

### Exceptions

`ParticleVersionException` - If the particle effect is not supported by the server version

`ParticleDataException` - If the particle effect does not require additional data or if the data type is incorrect

**See Also**
[#display(ParticleData, Vector, float, Location, List)](./display.md)

