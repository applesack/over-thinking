package xyz.scootaloo.thking.draft.test

import org.junit.jupiter.api.Test
import xyz.scootaloo.thking.draft.template.Template
import kotlin.system.measureTimeMillis

/**
 * @author flutterdash@qq.com
 * @since 2022/09/10 - 15:39
 */
class TemplateTest {

    @Test
    fun test0() {
        val template = Template("<div>{name}</div>")
        val params = mapOf("name" to "hello")
        println(template.fill(params))
    }

    @Test
    fun test1() {
        val template = Template("<div>{}</div><div>{}</div>")
        println(template.fillByOrder("aa"))
        println(template.fillByOrder("aa", "bb"))
    }

    @Test
    fun test2() {
        val template = Template("{a1}{a2}")
        println(template.fillByOrder("test1", "test2"))
    }

    @Test
    fun test3() {
        val text = "<D:response><D:href>{href}</D:href><D:status>{status}</D:status></D:response>"
        val template = Template(text)
        val param = mapOf("href" to "/book/hello/world", "status" to "HTTP/1.1 200 OK")
        val time = measureTimeMillis {
            repeat(10000) {
                template.fill(param)
            }
        }
        println(time)
    }

}
