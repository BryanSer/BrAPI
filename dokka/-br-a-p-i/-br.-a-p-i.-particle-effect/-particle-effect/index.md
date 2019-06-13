[BrAPI](../../index.md) / [Br.API.ParticleEffect](../index.md) / [ParticleEffect](./index.md)

# ParticleEffect

`class ParticleEffect`

**ParticleEffect Library**

 This library was created by @DarkBlade12 and allows you to display all Minecraft particle effects on a Bukkit server

 You are welcome to use it, modify it and redistribute it under the following conditions:

 * Don't claim this class as your own
* Don't remove this disclaimer


 Special thanks:

 * @microgeek (original idea, names and packet parameters)
* @ShadyPotato (1.8 names, ids and packet parameters)
* @RingOfStorms (particle behavior)
* @Cybermaxke (particle behavior)
* @JamieSinn (hosting a jenkins server and documentation for particleeffect)


 *It would be nice if you provide credit to me if you use this class in a published project* Modify by Bryan_lzh(BryanSer) for Bukkit version 1.10 and so on.

**Author**
DarkBlade12

**Version**
1.8

### Types

| Name | Summary |
|---|---|
| [BlockData](-block-data/index.md) | `class BlockData : `[`ParticleEffect.ParticleData`](-particle-data/index.md)<br>Represents the block data for the ``[`ParticleEffect#BLOCK_CRACK`](./index.md) and ``[`ParticleEffect#BLOCK_DUST`](./index.md) effects  |
| [ItemData](-item-data/index.md) | `class ItemData : `[`ParticleEffect.ParticleData`](-particle-data/index.md)<br>Represents the item data for the ``[`ParticleEffect#ITEM_CRACK`](./index.md) effect  |
| [NoteColor](-note-color/index.md) | `class NoteColor : `[`ParticleEffect.ParticleColor`](-particle-color/index.md)<br>Represents the color for the ``[`ParticleEffect#NOTE`](./index.md) effect  |
| [OrdinaryColor](-ordinary-color/index.md) | `class OrdinaryColor : `[`ParticleEffect.ParticleColor`](-particle-color/index.md)<br>Represents the color for effects like ``[`ParticleEffect#SPELL_MOB`](./index.md), ``[`ParticleEffect#SPELL_MOB_AMBIENT`](./index.md) and ``[`ParticleEffect#NOTE`](./index.md)  |
| [ParticleColor](-particle-color/index.md) | `abstract class ParticleColor`<br>Represents the color for effects like ``[`ParticleEffect#SPELL_MOB`](./index.md), ``[`ParticleEffect#SPELL_MOB_AMBIENT`](./index.md), ``[`ParticleEffect#REDSTONE`](./index.md) and ``[`ParticleEffect#NOTE`](./index.md)  |
| [ParticleData](-particle-data/index.md) | `abstract class ParticleData`<br>Represents the particle data for effects like ``[`ParticleEffect#ITEM_CRACK`](./index.md), ``[`ParticleEffect#BLOCK_CRACK`](./index.md) and ``[`ParticleEffect#BLOCK_DUST`](./index.md)  |
| [ParticlePacket](-particle-packet/index.md) | `class ParticlePacket`<br>Represents a particle effect packet with all attributes which is used for sending packets to the players  |
| [ParticleProperty](-particle-property/index.md) | `class ParticleProperty`<br>Represents the property of a particle effect  |

### Enum Values

| Name | Summary |
|---|---|
| [EXPLOSION_NORMAL](-e-x-p-l-o-s-i-o-n_-n-o-r-m-a-l.md) |  |
| [EXPLOSION_LARGE](-e-x-p-l-o-s-i-o-n_-l-a-r-g-e.md) |  |
| [EXPLOSION_HUGE](-e-x-p-l-o-s-i-o-n_-h-u-g-e.md) |  |
| [FIREWORKS_SPARK](-f-i-r-e-w-o-r-k-s_-s-p-a-r-k.md) |  |
| [WATER_BUBBLE](-w-a-t-e-r_-b-u-b-b-l-e.md) |  |
| [WATER_SPLASH](-w-a-t-e-r_-s-p-l-a-s-h.md) |  |
| [WATER_WAKE](-w-a-t-e-r_-w-a-k-e.md) |  |
| [SUSPENDED](-s-u-s-p-e-n-d-e-d.md) |  |
| [SUSPENDED_DEPTH](-s-u-s-p-e-n-d-e-d_-d-e-p-t-h.md) |  |
| [CRIT](-c-r-i-t.md) |  |
| [CRIT_MAGIC](-c-r-i-t_-m-a-g-i-c.md) |  |
| [SMOKE_NORMAL](-s-m-o-k-e_-n-o-r-m-a-l.md) |  |
| [SMOKE_LARGE](-s-m-o-k-e_-l-a-r-g-e.md) |  |
| [SPELL](-s-p-e-l-l.md) |  |
| [SPELL_INSTANT](-s-p-e-l-l_-i-n-s-t-a-n-t.md) |  |
| [SPELL_MOB](-s-p-e-l-l_-m-o-b.md) |  |
| [SPELL_MOB_AMBIENT](-s-p-e-l-l_-m-o-b_-a-m-b-i-e-n-t.md) |  |
| [SPELL_WITCH](-s-p-e-l-l_-w-i-t-c-h.md) |  |
| [DRIP_WATER](-d-r-i-p_-w-a-t-e-r.md) |  |
| [DRIP_LAVA](-d-r-i-p_-l-a-v-a.md) |  |
| [VILLAGER_ANGRY](-v-i-l-l-a-g-e-r_-a-n-g-r-y.md) |  |
| [VILLAGER_HAPPY](-v-i-l-l-a-g-e-r_-h-a-p-p-y.md) |  |
| [TOWN_AURA](-t-o-w-n_-a-u-r-a.md) |  |
| [NOTE](-n-o-t-e.md) |  |
| [PORTAL](-p-o-r-t-a-l.md) |  |
| [ENCHANTMENT_TABLE](-e-n-c-h-a-n-t-m-e-n-t_-t-a-b-l-e.md) |  |
| [FLAME](-f-l-a-m-e.md) |  |
| [LAVA](-l-a-v-a.md) |  |
| [FOOTSTEP](-f-o-o-t-s-t-e-p.md) |  |
| [CLOUD](-c-l-o-u-d.md) |  |
| [REDSTONE](-r-e-d-s-t-o-n-e.md) |  |
| [SNOWBALL](-s-n-o-w-b-a-l-l.md) |  |
| [SNOW_SHOVEL](-s-n-o-w_-s-h-o-v-e-l.md) |  |
| [SLIME](-s-l-i-m-e.md) |  |
| [HEART](-h-e-a-r-t.md) |  |
| [BARRIER](-b-a-r-r-i-e-r.md) |  |
| [ITEM_CRACK](-i-t-e-m_-c-r-a-c-k.md) |  |
| [BLOCK_CRACK](-b-l-o-c-k_-c-r-a-c-k.md) |  |
| [BLOCK_DUST](-b-l-o-c-k_-d-u-s-t.md) |  |
| [WATER_DROP](-w-a-t-e-r_-d-r-o-p.md) |  |
| [ITEM_TAKE](-i-t-e-m_-t-a-k-e.md) |  |
| [MOB_APPEARANCE](-m-o-b_-a-p-p-e-a-r-a-n-c-e.md) |  |

### Functions

| Name | Summary |
|---|---|
| [display](display.md) | `fun display(offsetX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetZ: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, range: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Displays a particle effect which is only visible for all players within a certain range in the world of @param center`fun display(offsetX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetZ: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun display(offsetX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetZ: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, vararg players: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Displays a particle effect which is only visible for the specified players`fun display(direction: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, range: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Displays a single particle which flies into a determined direction and is only visible for all players within a certain range in the world of`fun display(direction: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun display(direction: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, vararg players: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Displays a single particle which flies into a determined direction and is only visible for the specified players`fun display(color: `[`ParticleEffect.ParticleColor`](-particle-color/index.md)`!, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, range: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Displays a single particle which is colored and only visible for all players within a certain range in the world of @param center`fun display(color: `[`ParticleEffect.ParticleColor`](-particle-color/index.md)`!, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun display(color: `[`ParticleEffect.ParticleColor`](-particle-color/index.md)`!, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, vararg players: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Displays a single particle which is colored and only visible for the specified players`fun display(data: `[`ParticleEffect.ParticleData`](-particle-data/index.md)`!, offsetX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetZ: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, range: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Displays a particle effect which requires additional data and is only visible for all players within a certain range in the world of @param center`fun display(data: `[`ParticleEffect.ParticleData`](-particle-data/index.md)`!, offsetX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetZ: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun display(data: `[`ParticleEffect.ParticleData`](-particle-data/index.md)`!, offsetX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, offsetZ: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, vararg players: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Displays a particle effect which requires additional data and is only visible for the specified players`fun display(data: `[`ParticleEffect.ParticleData`](-particle-data/index.md)`!, direction: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, range: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Displays a single particle which requires additional data that flies into a determined direction and is only visible for all players within a certain range in the world of @param center`fun display(data: `[`ParticleEffect.ParticleData`](-particle-data/index.md)`!, direction: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!>!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun display(data: `[`ParticleEffect.ParticleData`](-particle-data/index.md)`!, direction: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!, speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, center: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, vararg players: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Displays a single particle which requires additional data that flies into a determined direction and is only visible for the specified players |
| [fromId](from-id.md) | `static fun fromId(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ParticleEffect`](./index.md)`!`<br>Returns the particle effect with the given id |
| [fromName](from-name.md) | `static fun fromName(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`ParticleEffect`](./index.md)`!`<br>Returns the particle effect with the given name |
| [getId](get-id.md) | `fun getId(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns the id of this particle effect |
| [getName](get-name.md) | `fun getName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!`<br>Returns the name of this particle effect |
| [getRequiredVersion](get-required-version.md) | `fun getRequiredVersion(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns the required version for this particle effect (1.x) |
| [hasProperty](has-property.md) | `fun hasProperty(property: `[`ParticleEffect.ParticleProperty`](-particle-property/index.md)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determine if this particle effect has a specific property |
| [isSupported](is-supported.md) | `fun isSupported(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determine if this particle effect is supported by your current server version |
