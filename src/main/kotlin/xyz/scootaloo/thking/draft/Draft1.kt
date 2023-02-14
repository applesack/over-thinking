package xyz.scootaloo.thking.draft

/**
 * @author flutterdash@qq.com
 * @since 2022/11/24 - 16:45
 */
object Draft1 {

    fun solution(a: String, b: String): Int {
        var tempA = a
        var count = 1
        var lenA = a.length
        val lenB = b.length
        while (lenA < (lenB * 2)) {
            if (tempA.contains(b)) {
                return count
            }
            count++
            tempA += a
            lenA = tempA.length
        }
        return -1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(solution("abcd", "cdabcdab"))
        println(solution("abcd", "cdabdab"))
        println(solution("ab", "cab"))
    }

}
