[BrAPI](../../index.md) / [com.github.bryanser.brapi](../index.md) / [Utils](index.md) / [safeGiveItem](./safe-give-item.md)

# safeGiveItem

`@JvmStatic fun safeGiveItem(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, item: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`, whenInvFull: (`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = ::safeDropItem): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/BryanSer/BrAPI/blob/ver-kotlin/src/main/kotlin/com/github/bryanser/brapi/Utils.kt#L114)

安全的添加物品到玩家背包,如果玩家背包满了. 会将物品丢弃到地上

### Parameters

`p` - 玩家

`item` - 物品

`whenInvFull` - 当背包满了的时候执行的操作 默认丢弃到附近:[safeDropItem](safe-drop-item.md)