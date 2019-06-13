[BrAPI](../../index.md) / [Br.API](../index.md) / [PlayerUseItemEvent](./index.md)

# PlayerUseItemEvent

`open class PlayerUseItemEvent : `[`Event`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Event.html)

**Author**
Bryan_lzh

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PlayerUseItemEvent(ID: `[`ItemInfo`](../-item-info/index.md)`!, p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!)` |

### Functions

| Name | Summary |
|---|---|
| [getHandlerList](get-handler-list.md) | `open static fun getHandlerList(): `[`HandlerList`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/HandlerList.html)`!` |
| [getHandlers](get-handlers.md) | `open fun getHandlers(): `[`HandlerList`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/HandlerList.html)`!` |
| [getItem](get-item.md) | `open fun getItem(): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!`<br>返回使用的物品 |
| [getItemInfo](get-item-info.md) | `open fun getItemInfo(): `[`ItemInfo`](../-item-info/index.md)`!` |
| [getPlayer](get-player.md) | `open fun getPlayer(): `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!`<br>返回玩家 |
| [removeAllItem](remove-all-item.md) | `open fun removeAllItem(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>移除所有这个物品 |
| [removeItem](remove-item.md) | `open fun removeItem(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>移除一个物品`open fun removeItem(i: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>移除指定数量的物品 |
