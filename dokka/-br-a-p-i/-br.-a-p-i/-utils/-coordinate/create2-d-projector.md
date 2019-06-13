[BrAPI](../../../index.md) / [Br.API](../../index.md) / [Utils](../index.md) / [Coordinate](index.md) / [create2DProjector](./create2-d-projector.md)

# create2DProjector

`open static fun create2DProjector(loc: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!, n: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`!): `[`BiFunction`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html)`<`[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`!, `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`!, `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`!>!`

创建二维→三维投影器

### Parameters

`loc` - [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!: 投影的原点

`n` - [Vector](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)!: 投影屏幕的法向量

**Return**
[BiFunction](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html)&lt;[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)!,&nbsp;[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)!,&nbsp;[Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)!&gt;!:

