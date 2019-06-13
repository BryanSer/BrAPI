[BrAPI](../../index.md) / [Br.API.Scripts](../index.md) / [ScriptLoader](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`ScriptLoader()`

nashorn脚本引擎存在一个明显的BUG 位于 jdk.nashorn.api.scripting.NashornScriptEngineFactory:431的静态方法getAppClassLoader 其中字节码描述如下:

  0: invokestatic java/lang/Thread.currentThread:()Ljava/lang/Thread; 3: invokevirtual java/lang/Thread.getContextClassLoader:()Ljava/lang/ClassLoader; 6: astore_0 7: aload_0 8: ifnonnull 19 11: ldc jdk/nashorn/api/scripting/NashornScriptEngineFactory 13: invokevirtual java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader; 16: goto 20 19: aload_0 20: areturn

 显然 代码返回的类加载器首先选取当前线程的类加载器(位于Thread.currentThread().getContextClassLoader()) 若返回null则返回NashornScriptEngineFactory的类加载器(NashornScriptEngineFactory.class.getClassLoader()) 这意味着 通过构造ScriptEngineManager所传入的类加载器没有任何用处 导致返回的ScriptEngine不使用所指定的类加载

**Author**
Bryan_lzh

**Version**
1.0

