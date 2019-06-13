[BrAPI](../../index.md) / [Br.API](../index.md) / [Utils](index.md) / [registerUseItemEvent](./register-use-item-event.md)

# registerUseItemEvent

`open static fun registerUseItemEvent(is: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!): `[`ItemInfo`](../-item-info/index.md)`!`

注册物品 将在被注册物品被玩家右键互交的时候触发 PlayerUseItemEvent. 返回值ItemData用于判断调用事件是哪个物品.

### Parameters

`is` - [ItemStack](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)!: 需要注册的物品

**Return**
[ItemInfo](../-item-info/index.md)!: ItemData 用于判断调用事件是哪个物品

