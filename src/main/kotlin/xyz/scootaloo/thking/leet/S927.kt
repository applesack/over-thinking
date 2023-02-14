package xyz.scootaloo.thking.leet

/**
 * @author flutterdash@qq.com
 * @since 2022/10/06 - 20:19
 */
class S927 {

    fun threeEqualParts(arr: IntArray): IntArray {
        val sum = arr.sum()
        if (sum % 3 != 0) {
            return intArrayOf(-1, -1)
        }
        if (sum == 0) {
            return intArrayOf(0, arr.size - 1)
        }

        val array = IntArray(sum)
        var pos = 0
        for (i in arr.indices) {
            if (arr[i] == 1) {
                array[pos++] = i
            }
        }

        val part = sum / 3
        val first = array[part - 1]
        val second = array[part * 2 - 1]
        val third = array[sum - 1]

        // 检查后导0
        if (array.last() != arr.size - 1) {
            val interval = arr.size - third - 1
            for (i in 1..interval) {
                if (arr[first + i] != arr[second + i] || arr[second + i] != arr[third + i]) {
                    return intArrayOf(-1, -1)
                }
            }
        }

        var count = part
        pos = 0
        while (true) {
            if (arr[first - pos] != arr[second - pos] || arr[second - pos] != arr[third - pos]) {
                return intArrayOf(-1, -1)
            }
            if (arr[first - pos] == 1) {
                count--
            }
            if (count == 0) {
                break
            }
            pos++
        }

        return if (array.last() != arr.size - 1) {
            val interval = arr.size - third - 1
            intArrayOf(first + interval, second + interval + 1)
        } else {
            intArrayOf(first, second + 1)
        }
    }

}
