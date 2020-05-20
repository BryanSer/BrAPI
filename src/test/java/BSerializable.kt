import com.github.bryanser.brapi.util.KConfigurationSerializable
import org.junit.Assert
import org.junit.Test

open class A {
    var s: String = "super"

}

class BSerializable : A, KConfigurationSerializable {
    @Transient
    var test: Int = 1

    var proxy: Int
        get() = test
        set(value) {
            test = value
        }

    private var privateInt: Int = 1
    val valInt: Int = 1
    @Transient
    var transientInt:Int = 1

    constructor() : super() {
    }

    constructor(map: Map<String, Any?>) : super() {
        map.deserialize()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BSerializable) return false

        if (test != other.test) return false
        if (s != other.s) return false

        return true
    }

    override fun hashCode(): Int {
        return test xor s.hashCode()
    }


}

class TestSerializable {
    @Test
    fun onSerializable() {
        val b = BSerializable()
        val map = b.serialize()
        Assert.assertEquals("{privateInt=1, proxy=1, s=super}", map.toString())
        val n = BSerializable(map)
        Assert.assertEquals(b, n)
    }
}