[BrAPI](../../../index.md) / [Br.API.ParticleEffect](../../index.md) / [ParticleEffect](../index.md) / [ParticlePacket](./index.md)

# ParticlePacket

`class ParticlePacket`

Represents a particle effect packet with all attributes which is used for sending packets to the players

 This class is part of the **ParticleEffect Library** and follows the same usage conditions

**Author**
DarkBlade12

**Since**
1.5

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ParticlePacket(effect: `[`ParticleEffect`](../index.md)`!, offsetX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetZ: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, longDistance: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, data: `[`ParticleEffect.ParticleData`](../-particle-data/index.md)`!)`<br>Construct a new particle packet`ParticlePacket(effect: `[`ParticleEffect`](../index.md)`!, direction: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, longDistance: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, data: `[`ParticleEffect.ParticleData`](../-particle-data/index.md)`!)`<br>Construct a new particle packet of a single particle flying into a determined direction`ParticlePacket(effect: `[`ParticleEffect`](../index.md)`!, color: `[`ParticleEffect.ParticleColor`](../-particle-color/index.md)`!, longDistance: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)`<br>Construct a new particle packet of a single colored particle |

### Functions

| Name | Summary |
|---|---|
| [getVersion](get-version.md) | `static fun getVersion(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns the version of your server (1.x) |
| [initialize](initialize.md) | `static fun initialize(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Initializes ``[`#packetConstructor`](#), ``[`#getHandle`](#), ``[`#playerConnection`](#) and ``[`#sendPacket`](#) and sets ``[`#initialized`](#) to `true` if it succeeds  |
| [isInitialized](is-initialized.md) | `static fun isInitialized(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determine if ``[`#packetConstructor`](#), ``[`#getHandle`](#), ``[`#playerConnection`](#) and ``[`#sendPacket`](#) are initialized |
| [sendTo](send-to.md) | `fun sendTo(center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, player: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sends the packet to a single player and caches it`fun sendTo(center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sends the packet to all players in the list`fun sendTo(center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, range: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sends the packet to all players in a certain range |
