[BrAPI](../../index.md) / [Br.API](../index.md) / [Calculator](./index.md)

# Calculator

`open class Calculator`

算数表达式求值 直接调用Calculator的类方法conversion() 传入算数表达式，将返回一个浮点值结果 如果计算过程错误，将返回一个NaN

**Author**
http://www.cnblogs.com/gmq/archive/2013/05/30/3108849.html 龚明秋 , Bryan_lzh 修改了原作者的代码 实现了多次方运算'^'

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Calculator()`<br>算数表达式求值 直接调用Calculator的类方法conversion() 传入算数表达式，将返回一个浮点值结果 如果计算过程错误，将返回一个NaN |

### Functions

| Name | Summary |
|---|---|
| [calculate](calculate.md) | `open fun calculate(expression: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>按照给定的表达式计算 |
| [compare](compare.md) | `open fun compare(cur: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`, peek: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>利用ASCII码-40做下标去算术符号优先级 |
| [conversion](conversion.md) | `open static fun conversion(expression: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
