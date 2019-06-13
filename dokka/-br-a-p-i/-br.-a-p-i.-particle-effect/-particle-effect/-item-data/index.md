[BrAPI](../../../index.md) / [Br.API.ParticleEffect](../../index.md) / [ParticleEffect](../index.md) / [ItemData](./index.md)

# ItemData

`class ItemData : `[`ParticleEffect.ParticleData`](../-particle-data/index.md)

Represents the item data for the ``[`ParticleEffect#ITEM_CRACK`](../index.md) effect

 This class is part of the **ParticleEffect Library** and follows the same usage conditions

**Author**
DarkBlade12

**Since**
1.6

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ItemData(material: `[`Material`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html)`!, data: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`)`<br>Construct a new item data |

### Inherited Functions

| Name | Summary |
|---|---|
| [getData](../-particle-data/get-data.md) | `open fun getData(): `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)<br>Returns the data value of this data |
| [getMaterial](../-particle-data/get-material.md) | `open fun getMaterial(): `[`Material`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html)`!`<br>Returns the material of this data |
| [getPacketData](../-particle-data/get-packet-data.md) | `open fun getPacketData(): `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`!`<br>Returns the data as an int array for packet construction |
| [getPacketDataString](../-particle-data/get-packet-data-string.md) | `open fun getPacketDataString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!`<br>Returns the data as a string for pre 1.8 versions |
