[BrAPI](../../index.md) / [Br.API.GUI.Ex.kt](../index.md) / [KtUIBuilder](./index.md)

# KtUIBuilder

`class KtUIBuilder`

### Properties

| Name | Summary |
|---|---|
| [allowShift](allow-shift.md) | `val allowShift: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [close](close.md) | `var close: `[`Close`](../-close.md)`?` |
| [contains](contains.md) | `val contains: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`KtItem`](../-kt-item/index.md)`?>` |
| [currencyIndex](currency-index.md) | `var currencyIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [displayName](display-name.md) | `val displayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [rows](rows.md) | `val rows: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [snapshotInit](snapshot-init.md) | `var snapshotInit: `[`SnapshotFactoryInit`](../-snapshot-factory-init.md)`?` |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `infix fun add(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`KtUIBuilder`](./index.md)<br>`infix fun add(item: `[`KtItem`](../-kt-item/index.md)`?): `[`KtUIBuilder`](./index.md)<br>`infix fun add(com: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, `[`KtItem`](../-kt-item/index.md)`?>): `[`KtUIBuilder`](./index.md) |
| [build](build.md) | `fun build(): `[`KtUI`](../-kt-u-i/index.md) |
| [dec](dec.md) | `operator fun dec(): `[`KtUIBuilder`](./index.md) |
| [inc](inc.md) | `operator fun inc(): `[`KtUIBuilder`](./index.md) |
| [minus](minus.md) | `operator fun minus(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`KtUIBuilder`](./index.md) |
| [minusAssign](minus-assign.md) | `operator fun minusAssign(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onClose](on-close.md) | `infix fun onClose(close: `[`Close`](../-close.md)`): `[`KtUIBuilder`](./index.md) |
| [plus](plus.md) | `operator fun plus(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`KtUIBuilder`](./index.md)<br>`operator fun plus(item: `[`KtItem`](../-kt-item/index.md)`?): `[`KtUIBuilder`](./index.md)<br>`operator fun plus(com: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, `[`KtItem`](../-kt-item/index.md)`?>): `[`KtUIBuilder`](./index.md) |
| [plusAssign](plus-assign.md) | `operator fun plusAssign(com: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, `[`KtItem`](../-kt-item/index.md)`?>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`operator fun plusAssign(item: `[`KtItem`](../-kt-item/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [remove](remove.md) | `infix fun remove(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`KtUIBuilder`](./index.md) |
| [setSnapshotInit](set-snapshot-init.md) | `fun setSnapshotInit(init: `[`SnapshotFactoryInit`](../-snapshot-factory-init.md)`?): `[`KtUIBuilder`](./index.md) |
| [times](times.md) | `operator fun times(init: `[`SnapshotFactoryInit`](../-snapshot-factory-init.md)`?): `[`KtUIBuilder`](./index.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [createUI](create-u-i.md) | `fun createUI(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, displayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, rows: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, allowShift: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`KtUIBuilder`](./index.md) |
