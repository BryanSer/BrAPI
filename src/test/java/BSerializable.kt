import com.github.bryanser.brapi.util.KConfigurationSerializable
import org.junit.Assert
import org.junit.Test

open class A {
    var s: String = "super"

}

class BSerializable : A, KConfigurationSerializable {
    var test: Int = 1

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
        Assert.assertEquals("{test=1, s=super}", map.toString())
        val n = BSerializable(map)
        Assert.assertEquals(b, n)
    }
}