package xyz.scootaloo.thking.rethinking

import org.junit.jupiter.api.Test
import kotlin.reflect.KClass

/**
 * @author AppleSack
 * @since  2023/05/15
 */
class ReflectTest {

    @Test
    fun test() {
        analysis(Gen1::class)
    }

    private fun analysis(klass: KClass<*>) {
        println(klass)
    }

    private class Gen1(var f1: Set<Set<Set<Pair<Long, String>>>>) {
        private lateinit var f2: List<List<List<Map<String, Long>>>>
    }

}
