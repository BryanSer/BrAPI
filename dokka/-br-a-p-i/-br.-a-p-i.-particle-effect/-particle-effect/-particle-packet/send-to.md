[BrAPI](../../../index.md) / [Br.API.ParticleEffect](../../index.md) / [ParticleEffect](../index.md) / [ParticlePacket](index.md) / [sendTo](./send-to.md)

# sendTo

`fun sendTo(center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, player: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sends the packet to a single player and caches it

### Parameters

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`player` - [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!: Receiver of the packet

### Exceptions

`PacketInstantiationException` - If instantion fails due to an unknown error

`PacketSendingException` - If sending fails due to an unknown error

**See Also**
[#initializePacket(Location)](#)

`fun sendTo(center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sends the packet to all players in the list

### Parameters

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`players` - [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!&gt;!: Receivers of the packet

### Exceptions

`IllegalArgumentException` - If the player list is empty

**See Also**
[#sendTo(Location center, Player player)](./send-to.md)

`fun sendTo(center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, range: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sends the packet to all players in a certain range

### Parameters

`center` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: Center location of the effect

`range` - [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html): Range in which players will receive the packet (Maximum range for particles is usually 16, but it can differ for some types)

### Exceptions

`IllegalArgumentException` - If the range is lower than 1

**See Also**
[#sendTo(Location center, Player player)](./send-to.md)

