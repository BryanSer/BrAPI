[BrAPI](../../../index.md) / [Br.API.ParticleEffect](../../index.md) / [ParticleEffect](../index.md) / [ParticlePacket](index.md) / [initialize](./initialize.md)

# initialize

`static fun initialize(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Initializes ``[`#packetConstructor`](#), ``[`#getHandle`](#), ``[`#playerConnection`](#) and ``[`#sendPacket`](#) and sets ``[`#initialized`](#) to `true` if it succeeds

 **Note:** These fields only have to be initialized once, so it will return if ``[`#initialized`](#) is already set to `true`

### Exceptions

`VersionIncompatibleException` - if your bukkit version is not supported by this library