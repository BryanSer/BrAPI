import com.github.bryanser.brapi.util.KConfigurationSerializable
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.configuration.serialization.ConfigurationSerialization
import org.junit.Assert
import org.junit.Test
import java.io.StringReader

class BSerializable : KConfigurationSerializable {
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
    var transientInt: Int = 1

    lateinit var map: MutableMap<String, Int>
    lateinit var emptyMap: MutableMap<String,String>

    constructor() {
        map = mutableMapOf("test" to 1, "data" to 2)
        emptyMap = mutableMapOf()
    }

    constructor(map: Map<String, Any?>)  {
        map.deserialize()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BSerializable) return false

        if (test != other.test) return false
        if (privateInt != other.privateInt) return false
        if (valInt != other.valInt) return false
        if (transientInt != other.transientInt) return false
        if (map != other.map) return false

        return true
    }

    override fun hashCode(): Int {
        var result = test
        result = 31 * result + privateInt
        result = 31 * result + valInt
        result = 31 * result + transientInt
        result = 31 * result + map.hashCode()
        return result
    }


}

class TestSerializable {
    @Test
    fun onSerializable() {
        ConfigurationSerialization.registerClass(BSerializable::class.java)
        val b = BSerializable()
        val yaml = YamlConfiguration()
        yaml.set("Test", b)
        val str = yaml.saveToString()
        val t = YamlConfiguration.loadConfiguration(StringReader(str))
        Assert.assertEquals(b, t["Test"])
    }
}