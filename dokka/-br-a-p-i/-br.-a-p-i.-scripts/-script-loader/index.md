[BrAPI](../../index.md) / [Br.API.Scripts](../index.md) / [ScriptLoader](./index.md)

# ScriptLoader

`open class ScriptLoader`

nashorn脚本引擎存在一个明显的BUG 位于 jdk.nashorn.api.scripting.NashornScriptEngineFactory:431的静态方法getAppClassLoader 其中字节码描述如下:

  0: invokestatic java/lang/Thread.currentThread:()Ljava/lang/Thread; 3: invokevirtual java/lang/Thread.getContextClassLoader:()Ljava/lang/ClassLoader; 6: astore_0 7: aload_0 8: ifnonnull 19 11: ldc jdk/nashorn/api/scripting/NashornScriptEngineFactory 13: invokevirtual java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader; 16: goto 20 19: aload_0 20: areturn

 显然 代码返回的类加载器首先选取当前线程的类加载器(位于Thread.currentThread().getContextClassLoader()) 若返回null则返回NashornScriptEngineFactory的类加载器(NashornScriptEngineFactory.class.getClassLoader()) 这意味着 通过构造ScriptEngineManager所传入的类加载器没有任何用处 导致返回的ScriptEngine不使用所指定的类加载

**Author**
Bryan_lzh

**Version**
1.0

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ScriptLoader()`<br>nashorn脚本引擎存在一个明显的BUG 位于 jdk.nashorn.api.scripting.NashornScriptEngineFactory:431的静态方法getAppClassLoader 其中字节码描述如下:  |

### Functions

| Name | Summary |
|---|---|
| [eval](eval.md) | `open static fun eval(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, fr: `[`Reader`](https://docs.oracle.com/javase/8/docs/api/java/io/Reader.html)`!): NashornScriptEngine!`<br>`open static fun eval(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, fr: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`!): NashornScriptEngine!`<br>`open static fun eval(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, c: `[`Consumer`](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)`<NashornScriptEngine!>!): NashornScriptEngine!` |
| [evalAsUTF8](eval-as-u-t-f8.md) | `open static fun evalAsUTF8(p: `[`Plugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/Plugin.html)`!, f: `[`File`](https://docs.oracle.com/javase/8/docs/api/java/io/File.html)`!): NashornScriptEngine!` |
