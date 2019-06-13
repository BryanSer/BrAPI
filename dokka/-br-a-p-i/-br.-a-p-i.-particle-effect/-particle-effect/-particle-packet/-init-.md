[BrAPI](../../../index.md) / [Br.API.ParticleEffect](../../index.md) / [ParticleEffect](../index.md) / [ParticlePacket](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`ParticlePacket(effect: `[`ParticleEffect`](../index.md)`!, offsetX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetZ: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, longDistance: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, data: `[`ParticleEffect.ParticleData`](../-particle-data/index.md)`!)`

Construct a new particle packet

### Parameters

`effect` - [ParticleEffect](../index.md)!: Particle effect

`offsetX` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the x-axis

`offsetY` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the y-axis

`offsetZ` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Maximum distance particles can fly away from the center on the z-axis

`speed` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Display speed of the particles

`amount` - [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): Amount of particles

`longDistance` - [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html): Indicates whether the maximum distance is increased from 256 to 65536

`data` - [ParticleEffect.ParticleData](../-particle-data/index.md)!: Data of the effect

### Exceptions

`IllegalArgumentException` - If the speed or amount is lower than 0

**See Also**
[#initialize()](initialize.md)

`ParticlePacket(effect: `[`ParticleEffect`](../index.md)`!, direction: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, longDistance: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, data: `[`ParticleEffect.ParticleData`](../-particle-data/index.md)`!)`

Construct a new particle packet of a single particle flying into a determined direction

### Parameters

`effect` - [ParticleEffect](../index.md)!: Particle effect

`direction` - [Vector](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)!: Direction of the particle

`speed` - [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html): Display speed of the particle

`longDistance` - [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html): Indicates whether the maximum distance is increased from 256 to 65536

`data` - [ParticleEffect.ParticleData](../-particle-data/index.md)!: Data of the effect

### Exceptions

`IllegalArgumentException` - If the speed is lower than 0

**See Also**
[#ParticlePacket(ParticleEffect, float, float, float, float, int, boolean, ParticleData)](./-init-.md)

`ParticlePacket(effect: `[`ParticleEffect`](../index.md)`!, color: `[`ParticleEffect.ParticleColor`](../-particle-color/index.md)`!, longDistance: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)`

Construct a new particle packet of a single colored particle

### Parameters

`effect` - [ParticleEffect](../index.md)!: Particle effect

`color` - [ParticleEffect.ParticleColor](../-particle-color/index.md)!: Color of the particle

`longDistance` - [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html): Indicates whether the maximum distance is increased from 256 to 65536

**See Also**
[#ParticlePacket(ParticleEffect, float, float, float, float, int, boolean, ParticleData)](./-init-.md)

