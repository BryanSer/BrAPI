[BrAPI](../../index.md) / [com.github.bryanser.brapi](../index.md) / [Utils](index.md) / [getLookAtEntity](./get-look-at-entity.md)

# getLookAtEntity

`@JvmStatic fun getLookAtEntity(e: `[`LivingEntity`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/LivingEntity.html)`, maxlength: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, ρ: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 50, exit: (`[`Block`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/block/Block.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = { it.type != Material.AIR }): `[`LivingEntity`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/LivingEntity.html)`?` [(source)](https://github.com/BryanSer/BrAPI/raw/ver-kotlin/src/main/kotlin/com/github/bryanser/brapi/Utils.kt#L263)

获得一个实体指针指向的实体

### Parameters

`e` - 实体

`maxlength` - 最大搜索距离

`ρ` - 搜索精度(越大越好) 默认50

`exit` - 停止搜索的条件, 默认为遇到非空气

**Return**

