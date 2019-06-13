[BrAPI](../../../index.md) / [Br.API.ParticleEffect](../../index.md) / [ParticleEffect](../index.md) / [ParticleData](./index.md)

# ParticleData

`abstract class ParticleData`

Represents the particle data for effects like ``[`ParticleEffect#ITEM_CRACK`](../index.md), ``[`ParticleEffect#BLOCK_CRACK`](../index.md) and ``[`ParticleEffect#BLOCK_DUST`](../index.md)

 This class is part of the **ParticleEffect Library** and follows the same usage conditions

**Author**
DarkBlade12

**Since**
1.6

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ParticleData(material: `[`Material`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html)`!, data: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`)`<br>Construct a new particle data |

### Functions

| Name | Summary |
|---|---|
| [getData](get-data.md) | `open fun getData(): `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)<br>Returns the data value of this data |
| [getMaterial](get-material.md) | `open fun getMaterial(): `[`Material`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html)`!`<br>Returns the material of this data |
| [getPacketData](get-packet-data.md) | `open fun getPacketData(): `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`!`<br>Returns the data as an int array for packet construction |
| [getPacketDataString](get-packet-data-string.md) | `open fun getPacketDataString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!`<br>Returns the data as a string for pre 1.8 versions |

### Inheritors

| Name | Summary |
|---|---|
| [BlockData](../-block-data/index.md) | `class BlockData : `[`ParticleEffect.ParticleData`](./index.md)<br>Represents the block data for the ``[`ParticleEffect#BLOCK_CRACK`](../index.md) and ``[`ParticleEffect#BLOCK_DUST`](../index.md) effects  |
| [ItemData](../-item-data/index.md) | `class ItemData : `[`ParticleEffect.ParticleData`](./index.md)<br>Represents the item data for the ``[`ParticleEffect#ITEM_CRACK`](../index.md) effect  |
