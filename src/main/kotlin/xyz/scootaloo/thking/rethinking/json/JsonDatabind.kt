package xyz.scootaloo.thking.rethinking.json

import java.lang.reflect.Field
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.reflect.KClass

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

    fun i() {
    }

    private fun registerDefault() {
        lock.read {

        }
    }
}


private interface JsonMapper : Iterable<JsonMapper> {
    fun createInstanceFromJson(json: Any?): Any?
    fun createJsonFromInstance(instance: Any?): String
    fun toJson(instance: Any?): Any?
}


private object EmptyMapperIterator : Iterator<JsonMapper> {
    override fun hasNext() = false
    override fun next() = throw IllegalStateException()
}


private object StringMapper : JsonMapper {
    override fun createInstanceFromJson(json: Any?): Any? {
        return json?.toString()
    }

    override fun createJsonFromInstance(instance: Any?): String {
        TODO()
    }

    override fun toJson(instance: Any?): Any? {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<JsonMapper> {
        return EmptyMapperIterator
    }
}


private class Mapper(private val type: KClass<*>) : JsonMapper {
    private val subMembers = LinkedHashMap<String, FieldBinding>()

    init {
        initialize()
    }

    override fun iterator(): Iterator<Mapper> {
        return MIterator(subMembers.values.map { it.mapper })
    }

    override fun createInstanceFromJson(json: Any?): Any? {
        TODO()
    }

    override fun createJsonFromInstance(instance: Any?): String {
        TODO("Not yet implemented")
    }

    override fun toJson(instance: Any?): Any? {
        TODO("Not yet implemented")
    }

    private fun initialize() {

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
