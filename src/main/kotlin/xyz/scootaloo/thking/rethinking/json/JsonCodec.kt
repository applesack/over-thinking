package xyz.scootaloo.thking.rethinking.json

import xyz.scootaloo.thking.rethinking.json.TypeInference.*
import java.io.StringReader
import java.util.*

/**
 * @author AppleSack
 * @since  2023/04/25
 */

object JsonCodec {
    fun formString(json: String?): Any? {
        assert(json != null) { "json cannot be null" }
        return fromString(json!!)
    }
}


class JsonParseException(msg: String) : RuntimeException(msg)


private enum class TypeInference {
    OBJECT, ARRAY, STRING, TRUE, FALSE, NUMBER, NULL, UNKNOWN
}


private class GlobalContext(
    val source: String,
    private var reader: StringReader = StringReader(source),
    private val stack: Stack<LocalContext> = Stack()
) {
    var lineNumber: Int = 1
        private set
    var pos: Int = -1
        private set
    var next: Int = 0
        private set

    private var backspace = false

    init {
        stack.add(LocalContext(UNKNOWN))
    }

    fun hasNext(): Boolean {
        if (!backspace) {
            next = reader.read()
        }
        return (next >= 0).apply {
            if (!backspace) {
                if (this) pos++
                if (next == '\n'.code) {
                    lineNumber++
                }
            } else {
                backspace = false
            }
        }
    }

    fun size(): Int = stack.size
    fun top(): LocalContext = stack.peek()
    fun pop(): LocalContext = stack.pop()
    fun push(type: TypeInference, value: ValueContainer) {
        stack.push(LocalContext(type, value))
    }

    fun isWhitespace(): Boolean {
        return next == ' '.code || next == '\n'.code
                || next == '\t'.code || next == '\r'.code
    }

    fun backspace() {
        backspace = true
    }
}


private class LocalContext(
    var type: TypeInference = UNKNOWN,
    var value: ValueContainer = UnknownValue
)


private fun fromString(string: String): Any? {
    val context = GlobalContext(string)
    while (context.hasNext()) {
        val local = context.top()
        if (local.type == UNKNOWN) {
            typeRecognition(context)
            continue
        }
        local.value.accept()
    }

    return context.pop().value.get()
}


private fun typeRecognition(global: GlobalContext) {
    if (global.isWhitespace()) {
        return
    }

    val ch = global.next
    val local = global.top()
    var type = local.type

    if (ch == '{'.code) {
        type = OBJECT
    } else if (ch == '['.code) {
        type = ARRAY
    } else if (ch == 't'.code || ch == 'f'.code) {
        type = if (ch == 't'.code) TRUE else FALSE
    } else if (ch == 'n'.code) {
        type = NULL
    } else if (ch == '\"'.code) {
        type = STRING
    } else if (ch == '+'.code || ch == '-'.code || ch.toChar().isDigit()) {
        type = NUMBER
    } else {
        throwParseException(global, "unknown datatype", (global.pos)..(global.pos))
    }

    local.type = type
    local.value = reifiedValueContainer(type, global)
}


private fun throwParseException(global: GlobalContext, errMsg: String, start: Int = global.pos) {
    throwParseException(global, errMsg, start..global.pos)
}


private fun throwParseException(global: GlobalContext, errMsg: String, range: IntRange) {
    val lineNumber = global.lineNumber
    val (errorLine, sPos, ePos) = fetchLine(global.source, lineNumber, range.first, range.last)
    val exMsg = markContent(lineNumber, errorLine, errMsg, sPos, ePos)
    throw JsonParseException(exMsg)
}


private fun fetchLine(
    text: String, lineNumber: Int, start: Int, end: Int
): Triple<String, Int, Int> {
    var (s, e) = start to end
    val lines = text.lines()
    for (i in lines.indices) {
        val line = lines[i]
        if (i == lineNumber - 1) {
            return Triple(line, s, e)
        }
        s -= line.length + 1
        e -= line.length + 1
    }

    throw IllegalStateException()
}


private fun markContent(line: Int, text: String, msg: String, start: Int, end: Int): String {
    // 89:         [1212,{]
    //                   ^^
    // exception: msg

    val lineNumber = "$line: "
    val builderLine1 = StringBuilder()
    val builderLine2 = StringBuilder()
    builderLine1.append(lineNumber).append(text)
    builderLine2.append(" ".repeat(builderLine1.length))
    for (i in start..end) {
        builderLine2[i + lineNumber.length] = '^'
    }
    return "\n$builderLine1\n$builderLine2\nexception: $msg\n"
}


private fun reifiedValueContainer(type: TypeInference, global: GlobalContext): ValueContainer {
    return when (type) {
        OBJECT -> ObjectValue(global)
        ARRAY -> ArrayValue(global)
        STRING -> StringValue(global)
        TRUE -> TrueValue(global)
        FALSE -> FalseValue(global)
        NUMBER -> NumberValue(global)
        NULL -> NullValue(global)
        UNKNOWN -> throw UnsupportedOperationException()
    }
}


private object ValueConstant {
    const val NULL = "null"
    const val TRUE = "true"
    const val FALSE = "false"
}


private interface ValueContainer {
    fun accept()
    fun get(): Any?
}


private interface ValueSetter {
    fun setValue(value: Any?)
}


private object UnknownValue : ValueContainer {
    override fun accept() = throw UnsupportedOperationException()
    override fun get(): Any = throw UnsupportedOperationException()
}


private open class ConstantValue(
    private val global: GlobalContext, private val constant: String, private var pos: Int = 1
) : ValueContainer {
    override fun accept() {
        if (pos >= constant.length) {
            throwParseException(global, "unknown datatype", (global.pos - pos)..(global.pos))
        }
        if (global.next != constant[pos].code) {
            throwParseException(global, "unknown datatype", (global.pos - pos)..(global.pos))
        }
        pos++
        if (pos == constant.length) {
            Helper.reduce(global)
        }
    }

    override fun get(): Any? {
        if (pos != constant.length) {
            throwParseException(global, "illegal close symbol", (global.pos - pos)..(global.pos))
        }
        if (constant === ValueConstant.TRUE) {
            return true
        }
        if (constant === ValueConstant.FALSE) {
            return false
        }
        return null
    }
}


private class TrueValue(global: GlobalContext) : ConstantValue(global, ValueConstant.TRUE)


private class FalseValue(global: GlobalContext) : ConstantValue(global, ValueConstant.FALSE)


private class NullValue(global: GlobalContext) : ConstantValue(global, ValueConstant.NULL)


private class ObjectValue(private val global: GlobalContext) : ValueContainer, ValueSetter {
    private enum class MapperState {
        EXPECT_KEY, EXPECT_VALUE, EXPECT_COLON, EXPECT_CLOSE
    }

    private class Entry(var key: String? = null, var value: Any? = null)

    private val map = LinkedHashMap<String, Any?>()
    private val entry = Entry()
    private var state = MapperState.EXPECT_KEY

    override fun accept() {
        when (state) {
            MapperState.EXPECT_KEY -> onKey()
            MapperState.EXPECT_COLON -> onColon()
            MapperState.EXPECT_VALUE -> onValue()
            MapperState.EXPECT_CLOSE -> onClose()
        }
    }

    override fun get(): Any {
        return JsonObject(map)
    }

    override fun setValue(value: Any?) {
        if (state == MapperState.EXPECT_KEY) {
            if (value == null) {
                throwParseException(global, "expect a key, but an illegal symbol is found")
            }
            if (value !is String) {
                throwParseException(global, "expect a value, but an illegal symbol is found")
            }
            entry.key = value as String
            state = MapperState.EXPECT_COLON
        } else {
            if (state != MapperState.EXPECT_VALUE) {
                throwParseException(global, "illegal symbol")
            }
            entry.value = value
            state = MapperState.EXPECT_CLOSE
        }
    }

    private fun onKey() {
        if (global.isWhitespace()) {
            return
        }
        when (global.next) {
            '\"'.code -> global.push(STRING, StringValue(global))
            '}'.code -> onClose()
            else -> throwParseException(global, "illegal key expression")
        }
    }

    private fun onColon() {
        if (global.isWhitespace()) {
            return
        }
        if (global.next == ':'.code) {
            state = MapperState.EXPECT_VALUE
        } else {
            throwParseException(global, "expect ':', but '${global.next.toChar()}' found")
        }
    }

    private fun onValue() {
        if (global.isWhitespace()) {
            return
        }
        global.push(UNKNOWN, UnknownValue)
        typeRecognition(global)
    }

    private fun onClose() {
        if (global.isWhitespace()) {
            return
        }

        when (global.next) {
            ','.code -> {
                collectValue()
                state = MapperState.EXPECT_KEY
            }

            '}'.code -> {
                collectValue()
                Helper.reduce(global)
            }

            else -> {
                throwParseException(global, "illegal close expression")
            }
        }
    }

    private fun collectValue() {
        map[entry.key ?: return] = entry.value
        entry.key = null
        entry.value = null
    }
}


private class ArrayValue(private val global: GlobalContext) : ValueContainer, ValueSetter {
    private enum class ArrayState {
        EXPECT_VALUE, EXPECT_CLOSE
    }

    private val array = ArrayList<Any?>()
    private var state = ArrayState.EXPECT_VALUE

    private var validValue = false
    private var value: Any? = null

    override fun setValue(value: Any?) {
        validValue = true
        this.value = value
        state = ArrayState.EXPECT_CLOSE
    }

    override fun accept() {
        when (state) {
            ArrayState.EXPECT_VALUE -> onValue()
            ArrayState.EXPECT_CLOSE -> onClose()
        }
    }

    override fun get(): Any {
        if (state == ArrayState.EXPECT_VALUE) {
            throwParseException(global, "close symbol of array not found")
        }
        return JsonArray(array)
    }

    private fun onValue() {
        if (global.isWhitespace()) {
            return
        }
        if (global.next == ']'.code) {
            return onClose()
        }

        global.push(UNKNOWN, UnknownValue)
        typeRecognition(global)
    }

    private fun onClose() {
        fun setAndClear() {
            if (validValue) {
                array.add(value)
                validValue = false
            }
            value = null
        }

        if (global.isWhitespace()) {
            return
        }

        when (global.next) {
            ','.code -> {
                setAndClear()
                state = ArrayState.EXPECT_VALUE
            }

            ']'.code -> {
                setAndClear()
                state = ArrayState.EXPECT_CLOSE
                Helper.reduce(global)
            }

            else -> throwParseException(global, "illegal array close symbol")
        }
    }
}


private class StringValue(private val global: GlobalContext) : ValueContainer {
    private enum class StringState {
        NORMAL, ESCAPE, HEX
    }

    private var state = StringState.NORMAL
    private val builder = StringBuilder()
    private var hexBuilder = StringBuilder(4)

    override fun accept() {
        when (state) {
            StringState.ESCAPE -> escape()
            StringState.HEX -> hex()
            else -> push()
        }
    }

    override fun get(): Any {
        if (state != StringState.NORMAL) {
            throwParseException(global, "close symbol of string not found")
        }
        return builder.toString()
    }

    private fun escape() {
        when (global.next) {
            '\"'.code -> builder.append('"')
            '\\'.code -> builder.append('\\')
            '/'.code -> builder.append('/')
            'b'.code -> builder.append('\b')
            'f'.code -> builder.append("\u000c")
            'n'.code -> builder.append('\n')
            'r'.code -> builder.append('\r')
            't'.code -> builder.append('\t')
            'u'.code -> {
                state = StringState.HEX
            }
        }
    }

    private fun hex() {
        hexBuilder.append(global.next.toChar())
        if (hexBuilder.length == 4) {
            val hexContent = Helper.hex2int(hexBuilder.toString())
            builder.append(hexContent.toChar())
            hexBuilder.clear()
            state = StringState.NORMAL
        }
    }

    private fun push() {
        when (val ch = global.next) {
            '\"'.code -> Helper.reduce(global)
            '\\'.code -> state = StringState.ESCAPE
            else -> builder.append(ch.toChar())
        }
    }
}


private class NumberValue(private val global: GlobalContext) : ValueContainer {

    private val builder = StringBuilder()

    init {
        builder.append(global.next.toChar())
    }

    override fun accept() {
        val ch = global.next.toChar()
        if (Character.isDigit(ch) || ch == 'e' || ch == 'E'
            || ch == '.' || ch == '+' || ch == '-'
        ) {
            builder.append(ch)
        } else {
            global.backspace()
            Helper.reduce(global)
        }
    }

    override fun get(): Any {
        val number = builder.toString()
        if ('.' in number) {
            return number.toDouble()
        }
        return number.toLong()
    }
}


private object Helper {
    fun reduce(global: GlobalContext) {
        if (global.size() > 1) {
            val curValue = global.pop().value.get()
            val topElement = global.top().value
            if (topElement is ValueSetter) {
                topElement.setValue(curValue)
            } else {
                throwParseException(global, "illegal nested structure")
            }
        }
    }

    fun hex2int(hex: String): Int {
        return Integer.parseInt(hex, 16)
    }
}
