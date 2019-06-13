[BrAPI](../../index.md) / [Br.API.NBT](../index.md) / [AttributeModifiers](./index.md)

# AttributeModifiers

`open class AttributeModifiers : `[`BrConfigurationSerializable`](../../-br.-a-p-i.-data/-br-configuration-serializable/index.md)

**Author**
Bryan_lzh

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AttributeModifiers()`<br>`AttributeModifiers(args: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>!)` |

### Functions

| Name | Summary |
|---|---|
| [addAttribute](add-attribute.md) | `open static fun addAttribute(is: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!, at: `[`AttributeType`](../-attribute-type/index.md)`!, value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, opt: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!`<br>`open static fun addAttribute(is: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!, at: `[`AttributeType`](../-attribute-type/index.md)`!, value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, slot: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, opt: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!` |
| [getAttribute](get-attribute.md) | `open fun getAttribute(at: `[`AttributeType`](../-attribute-type/index.md)`!): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [getSolt](get-solt.md) | `open fun getSolt(): `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!>!` |
| [removeAttribute](remove-attribute.md) | `open static fun removeAttribute(is: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!, at: `[`AttributeType`](../-attribute-type/index.md)`!): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!` |
| [setAttribute](set-attribute.md) | `open fun setAttribute(at: `[`AttributeType`](../-attribute-type/index.md)`!, value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, opt: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>操作值0: 直接加上value |
| [setItem](set-item.md) | `open fun setItem(is: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!): `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`!` |

### Inherited Functions

| Name | Summary |
|---|---|
| [serialize](../../-br.-a-p-i.-data/-br-configuration-serializable/serialize.md) | `open fun serialize(): `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`!>!` |
