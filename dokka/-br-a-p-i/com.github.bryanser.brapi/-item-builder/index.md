[BrAPI](../../index.md) / [com.github.bryanser.brapi](../index.md) / [ItemBuilder](./index.md)

# ItemBuilder

`object ItemBuilder` [(source)](https://github.com/BryanSer/BrAPI/blob/ver-kotlin/src/main/kotlin/com/github/bryanser/brapi/ItemBuilder.kt#L14)

构造物品工具
用法:

```
val item = (ItemBuilder create Material.STONE name "§6物品名" lore "lore")()
```

### Types

| Name | Summary |
|---|---|
| [Building](-building/index.md) | `data class Building`<br>物品构造器 |

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `infix fun create(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ItemBuilder.Building`](-building/index.md)<br>`infix fun create(material: `[`Material`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html)`): `[`ItemBuilder.Building`](-building/index.md)<br>创建一个物品构造器 |
| [times](times.md) | `operator fun times(material: `[`Material`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html)`): `[`ItemBuilder.Building`](-building/index.md)<br>`operator fun times(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ItemBuilder.Building`](-building/index.md)<br>创建一个物品构造器 |
