[BrAPI](../../index.md) / [Br.API](../index.md) / [ArithHelper](index.md) / [div](./div.md)

# div

`open static fun div(v1: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, v2: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。

### Parameters

`v1` - [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html): 被除数

`v2` - [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html): 除数

**Return**
[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html): 两个参数的商

`open static fun div(v1: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!, v2: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`open static fun div(v1: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, v2: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, scale: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。

### Parameters

`v1` - [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html): 被除数

`v2` - [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html): 除数

`scale` - [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): 表示表示需要精确到小数点以后几位。

**Return**
[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html): 两个参数的商

