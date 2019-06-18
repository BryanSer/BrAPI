[BrAPI](../../index.md) / [com.github.bryanser.brapi](../index.md) / [Utils](index.md) / [getLineEntitys](./get-line-entitys.md)

# getLineEntitys

`@JvmStatic fun getLineEntitys(loc: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`, vector: `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)`? = null, maxlength: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 20.0, ρ: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 20, exit: (`[`Block`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/block/Block.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = { it.type != Material.AIR }): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Entity`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Entity.html)`>` [(source)](https://github.com/BryanSer/BrAPI/blob/ver-kotlin/src/main/kotlin/com/github/bryanser/brapi/Utils.kt#L289)

获得一条直线上的实体们

### Parameters

`loc` - 起点

`vector` - 方向

`maxlength` - 最大搜索半径

`ρ` - 搜索精度(越大越好) 默认50

`exit` - 停止搜索的条件, 默认为遇到非空气

**Return**

