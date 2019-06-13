[BrAPI](../../index.md) / [Br.API](../index.md) / [CallBack](index.md) / [sendButtonRequest](./send-button-request.md)

# sendButtonRequest

`open static fun sendButtonRequest(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, msg: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!>!, callback: `[`BiConsumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`!>!, overtime: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

向玩家发送一堆按钮 按钮的的内容将由msg决定,最后通过BiConsumer来返回执行玩家按下的按钮

 按钮计数从0开始 超时overtime秒则传入null

### Parameters

`p` - [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!:

`msg` - [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)!&gt;!:

`callback` - [BiConsumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)&lt;[Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)!,&nbsp;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)!&gt;!: 注意 Integer参数为null时表示超时 玩家如果中途退出游戏也会触发null

`overtime` - [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html): 超时时间 单位秒

**Return**
[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html): true时表示 请求成功 false时表示 上个处理还未完成

`open static fun sendButtonRequest(p: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, msg: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!>!, callback: `[`BiConsumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`!, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`!>!, overtime: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, format: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)