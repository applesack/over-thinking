package xyz.scootaloo.thking.draft.template

/**
 * @author flutterdash@qq.com
 * @since 2022/09/10 - 14:37
 */
class Template(private val template: String) {

    private val fillParams = ArrayList<Triple<Int, Int, String>>()
    private var used = 0

    init {
        analysis()
    }

    fun fill(params: Map<String, String>): String {
        var begin = 0

        val buff = StringBuilder(calculateBufferCapacity(params))
        for ((paramStart, paramEnd, paramName) in fillParams) {
            buff.append(template.substring(begin, paramStart))
            buff.append(params[paramName])
            begin = paramEnd + 1
        }
        buff.append(template.substring(begin))

        return buff.toString()
    }

    fun fillByOrder(vararg params: String): String {
        var begin = 0

        val buff = StringBuilder(calculateBufferCapacity(*params))
        for (idx in fillParams.indices) {
            val (paramStart, paramEnd, _) = fillParams[idx]
            buff.append(template.substring(begin, paramStart))
            if (params.size > idx) {
                buff.append(params[idx])
            } else {
                buff.append("{}")
            }

            begin = paramEnd + 1
        }
        buff.append(template.substring(begin))

        return buff.toString()
    }

    private fun calculateBufferCapacity(params: Map<String, String>): Int {
        return used + params.map { it.value.length }.sum() + 5
    }

    private fun calculateBufferCapacity(vararg params: String): Int {
        return used + params.sumOf { it.length } + 5
    }

    private fun analysis() {
        val params = HashMap<String, ArrayList<Pair<Int, Int>>>()

        var start = -1
        for (idx in template.indices) {
            val ch = template[idx]
            if (ch == '}') {
                if (start == -1) {
                    continue
                }

                val name = template.substring(start + 1, idx)
                if ('{' in name) {
                    start = -1
                    continue
                }

                val list = params[name] ?: ArrayList()
                if (name !in params) {
                    params[name] = list
                }

                list.add(start to idx)
            } else if (ch == '{') {
                start = idx
            }
        }

        collectFillParams(params)
        calculateUsed()
    }

    private fun collectFillParams(params: Map<String, List<Pair<Int, Int>>>) {
        for ((name, list) in params) {
            for (pair in list) {
                fillParams.add(Triple(pair.first, pair.second, name))
            }
        }

        fillParams.sortBy { it.first }
    }

    private fun calculateUsed() {
        used = 0
        for (param in fillParams) {
            used += (param.second - param.first + 1)
        }
        used = template.length - used
    }

}
