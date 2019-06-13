[BrAPI](../../index.md) / [Br.API.NBT](../index.md) / [AttributeModifiers](index.md) / [setAttribute](./set-attribute.md)

# setAttribute

`open fun setAttribute(at: `[`AttributeType`](../-attribute-type/index.md)`!, value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, opt: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

操作值0: 直接加上value

 操作值1: 在其他0操作计算完成后百分比加成

 操作值2: 在操作值1全部完成后进行百分比加成.

### Parameters

`at` - [AttributeType](../-attribute-type/index.md)!: 属性类型

`value` - [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html): 属性值

`opt` - [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): 属性操作值