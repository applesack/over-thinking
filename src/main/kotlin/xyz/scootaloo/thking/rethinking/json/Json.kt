package xyz.scootaloo.thking.rethinking.json

import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

/**
 * @author AppleSack
 * @since 2023/05/02
 */

@Suppress("unused")
data class JsonObject(
    private val map: MutableMap<String, Any?> = HashMap()
) : MutableMap<String, Any?> by map {
    fun getString(key: String): String? = getString0(map[key])
    fun getByte(key: String): Byte? = getByte0(map[key])
    fun getShort(key: String): Short? = getShort0(map[key])
    fun getInt(key: String): Int? = getInt0(map[key])
    fun getFloat(key: String): Float? = getFloat0(map[key])
    fun getDouble(key: String): Double? = getDouble0(map[key])
    fun getLong(key: String): Long? = getLong0(map[key])
    fun getBool(key: String): Boolean? = getBool0(map[key])
}


@Suppress("unused")
data class JsonArray(
    private val arr: ArrayList<Any?> = ArrayList()
) : MutableList<Any?> by arr {
    fun getString(index: Int): String? = getString0(arr[index])
    fun getByte(index: Int): Byte? = getByte0(arr[index])
    fun getShort(index: Int): Short? = getShort0(arr[index])
    fun getInt(index: Int): Int? = getInt0(arr[index])
    fun getFloat(index: Int): Float? = getFloat0(arr[index])
    fun getDouble(index: Int): Double? = getDouble0(arr[index])
    fun getLong(index: Int): Long? = getLong0(arr[index])
    fun getBool(index: Int): Boolean? = getBool0(arr[index])
}


private fun getString0(value: Any?): String? = getValueAs(value, String::class)
private fun getByte0(value: Any?): Byte? = getValueAs(value, Byte::class)
private fun getShort0(value: Any?): Short? = getValueAs(value, Short::class)
private fun getInt0(value: Any?): Int? = getValueAs(value, Int::class)
private fun getFloat0(value: Any?): Float? = getValueAs(value, Float::class)
private fun getDouble0(value: Any?): Double? = getValueAs(value, Double::class)
private fun getLong0(value: Any?): Long? = getValueAs(value, Long::class)
private fun getBool0(value: Any?): Boolean? = getValueAs(value, Boolean::class)


private fun <T : Any> getValueAs(value: Any?, type: KClass<T>): T? {
    if (value == null) {
        return null
    }

    if (type.isSubclassOf(Number::class)) {
        val number = value as Number
        when (type) {
            Byte::class -> number.toByte()
            Short::class -> number.toShort()
            Int::class -> number.toInt()
            Float::class -> number.toFloat()
            Double::class -> number.toFloat()
            Long::class -> number.toLong()
            else -> {
                throw UnsupportedOperationException("$value cannot cast to $type")
            }
        }
    }

    if (type == Boolean::class) {
        @Suppress("unchecked_cast")
        return value as T
    }

    @Suppress("unchecked_cast")
    return value.toString() as T
}


object Json {
    fun pretty(json: String, indent: Int = 2): String {
        return JsonFormatter(indent, JsonCodec.formString(json)).format()
    }

    private class JsonFormatter(val indentUnit: Int, val json: Any?) {
        private val builder = StringBuilder()
        private var indent = 0

        fun format(): String {
            builder.setLength(0)
            formatAny(json)
            return builder.toString()
        }

        private fun formatAny(source: Any?) {
            when (source) {
                is JsonObject -> formatMap(source)
                is JsonArray -> formatArray(source)
                else -> formatValue(source)
            }
        }

        private fun formatMap(map: JsonObject) {
            if (map.isEmpty()) {
                builder.append("{}")
                return
            }

            builder.append("{\n")
            intendBlock {
                for ((key, value) in map) {
                    makeIntend()
                    builder.append("\"").append(key).append("\"")
                    builder.append(": ")
                    formatAny(value)
                    builder.append(",\n")
                }
            }
            builder.setLength(builder.length - 2)
            builder.append("\n")
            makeIntend()
            builder.append("}")
        }

        private fun formatArray(arr: JsonArray) {
            if (arr.isEmpty()) {
                builder.append("[]")
                return
            }

            builder.append("[\n")
            intendBlock {
                for (value in arr) {
                    makeIntend()
                    formatAny(value)
                    builder.append(",\n")
                }
            }
            builder.setLength(builder.length - 2)
            builder.append('\n')
            makeIntend()
            builder.append("]")
        }

        private fun formatValue(value: Any?) {
            if (value == null) {
                builder.append("null")
            } else {
                builder.append(value)
            }
        }

        private fun intendBlock(block: () -> Unit) {
            indent += indentUnit
            block()
            indent -= indentUnit
        }

        private fun makeIntend() {
            builder.append(" ".repeat(indent))
        }
    }
}
