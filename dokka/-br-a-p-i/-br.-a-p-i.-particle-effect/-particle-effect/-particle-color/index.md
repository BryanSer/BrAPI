[BrAPI](../../../index.md) / [Br.API.ParticleEffect](../../index.md) / [ParticleEffect](../index.md) / [ParticleColor](./index.md)

# ParticleColor

`abstract class ParticleColor`

Represents the color for effects like ``[`ParticleEffect#SPELL_MOB`](../index.md), ``[`ParticleEffect#SPELL_MOB_AMBIENT`](../index.md), ``[`ParticleEffect#REDSTONE`](../index.md) and ``[`ParticleEffect#NOTE`](../index.md)

 This class is part of the **ParticleEffect Library** and follows the same usage conditions

**Author**
DarkBlade12

**Since**
1.7

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ParticleColor()`<br>Represents the color for effects like ``[`ParticleEffect#SPELL_MOB`](../index.md), ``[`ParticleEffect#SPELL_MOB_AMBIENT`](../index.md), ``[`ParticleEffect#REDSTONE`](../index.md) and ``[`ParticleEffect#NOTE`](../index.md)  |

### Functions

| Name | Summary |
|---|---|
| [getValueX](get-value-x.md) | `abstract fun getValueX(): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>Returns the value for the offsetX field |
| [getValueY](get-value-y.md) | `abstract fun getValueY(): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>Returns the value for the offsetY field |
| [getValueZ](get-value-z.md) | `abstract fun getValueZ(): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>Returns the value for the offsetZ field |

### Inheritors

| Name | Summary |
|---|---|
| [NoteColor](../-note-color/index.md) | `class NoteColor : `[`ParticleEffect.ParticleColor`](./index.md)<br>Represents the color for the ``[`ParticleEffect#NOTE`](../index.md) effect  |
| [OrdinaryColor](../-ordinary-color/index.md) | `class OrdinaryColor : `[`ParticleEffect.ParticleColor`](./index.md)<br>Represents the color for effects like ``[`ParticleEffect#SPELL_MOB`](../index.md), ``[`ParticleEffect#SPELL_MOB_AMBIENT`](../index.md) and ``[`ParticleEffect#NOTE`](../index.md)  |
