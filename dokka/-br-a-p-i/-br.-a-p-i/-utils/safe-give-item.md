[BrAPI](../../index.md) / [Br.API](../index.md) / [Utils](index.md) / [safeGiveItem](./safe-give-item.md)

# safeGiveItem

`open static fun safeGiveItem(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, is: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

安全的添加物品到玩家背包,如果玩家背包满了. 会将物品丢弃到地上

### Parameters

`p` - [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!: 玩家

`is` - [ItemStack](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)!: 物品