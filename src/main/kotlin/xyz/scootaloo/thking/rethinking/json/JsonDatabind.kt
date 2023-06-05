package xyz.scootaloo.thking.rethinking.json

import java.lang.reflect.Constructor
import java.lang.reflect.Field
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

/**
 * @author AppleSack
 * @since 2023/05/02
 */
object JsonDatabind {
    private val lock = ReentrantReadWriteLock()
    private val map = HashMap<String, JsonMapper>()

    init {
        registerDefault()
    }

    fun toJSONObject(obj: Any?): JsonObject? {
        return typeMapper(getTypeName(obj)).object2json(obj) as JsonObject?
    }

    fun toJsonArray(obj: Any?): JsonArray? {
        TODO()
    }

    fun toJsonString() {

    }

    private fun typeMapper(typeName: String): JsonMapper {
        return lock.read { map[typeName] } ?: throw RuntimeException("json mapper of $typeName not found")
    }

    private fun getTypeName(obj: Any?): String {
        if (obj == null) {
            return "null"
        }
        return obj::javaClass.name
    }

    private fun registerDefault() {
        lock.write {

        }
    }
}


private interface JsonMapper : Iterable<JsonMapper> {
    fun json2object(json: Any?): Any?
    fun object2json(instance: Any?): Any?
}


private object EmptyMapperIterator : Iterator<JsonMapper> {
    override fun hasNext() = false
    override fun next() = throw IllegalStateException()
}


private object StringMapper : JsonMapper {
    override fun json2object(json: Any?) = json?.toString()
    override fun object2json(instance: Any?) = instance
    override fun iterator() = EmptyMapperIterator
}


private object BooleanMapper : JsonMapper {
    override fun json2object(json: Any?) = if (json == null) null else json == true
    override fun object2json(instance: Any?) = instance
    override fun iterator() = EmptyMapperIterator
}


private object ByteMapper : JsonMapper {
    override fun json2object(json: Any?) = (json as Number?)?.toByte()
    override fun object2json(instance: Any?) = instance
    override fun iterator() = EmptyMapperIterator
}


private object ShortMapper : JsonMapper {
    override fun json2object(json: Any?) = (json as Number?)?.toShort()
    override fun object2json(instance: Any?) = instance
    override fun iterator() = EmptyMapperIterator
}


private object IntMapper : JsonMapper {
    override fun json2object(json: Any?) = (json as Number?)?.toInt()
    override fun object2json(instance: Any?) = instance
    override fun iterator() = EmptyMapperIterator
}


private object FloatMapper : JsonMapper {
    override fun json2object(json: Any?) = (json as Number?)?.toFloat()
    override fun object2json(instance: Any?) = instance
    override fun iterator() = EmptyMapperIterator
}


private object DoubleMapper : JsonMapper {
    override fun json2object(json: Any?) = (json as Number?)?.toDouble()
    override fun object2json(instance: Any?) = instance
    override fun iterator() = EmptyMapperIterator
}


private object LongMapper : JsonMapper {
    override fun json2object(json: Any?) = (json as Number?)?.toLong()
    override fun object2json(instance: Any?) = instance
    override fun iterator() = EmptyMapperIterator
}


// object
private class Mapper(private val type: KClass<*>) : JsonMapper {
    private val members = LinkedHashMap<String, FieldBinding>()
    private lateinit var constructor: KFunction<*>

    init {
        initialize()
    }

    override fun iterator(): Iterator<Mapper> {
        return MIterator(members.values.map { it.mapper })
    }

    override fun json2object(json: Any?): Any? {
        TODO()
    }

    override fun object2json(instance: Any?): Any? {
        TODO("Not yet implemented")
    }

    private fun instantiate(): Any {
        TODO()
    }

    private fun initialize() {
        var found = false
        for (constructor in type.constructors) {
            if (constructor.parameters.isEmpty()) {
                constructor.isAccessible = true
                this.constructor = constructor
                found = true
                break
            }
        }
        if (!found) {
            throw RuntimeException("empty constructor not found")
        }

        for (property in type.memberProperties) {
        }
    }

    private class MIterator(
        private val mappers: Collection<Mapper>
    ) : Iterator<Mapper> by mappers.iterator()
}


private class FieldBinding(val field: Field, val mapper: Mapper) {
    init {
        field.isAccessible = true
    }

    operator fun set(receiver: Any, value: Any?) {
        field[receiver] = value
    }

    operator fun get(receiver: Any): Any? {
        return field[receiver]
    }
}
