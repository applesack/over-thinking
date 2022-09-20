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
        /**
         * 填充模板10万次, 测试10次(时间单位毫秒)
         * 预计算容量: 58, 60, 71, 54, 50, 54, 57, 49, 48, 55
         * 不预加计算: 48, 47
         */
        val text = """
            <?xml version="1.0" encoding="utf-8" ?> 
                <D:lockinfo xmlns:D="DAV:"> 
                    <D:locktype><D:{type}/></D:locktype> 
                    <D:lockscope><D:{scope}/></D:lockscope> 
                <D:owner> 
                <D:href>{href}</D:href> 
                </D:owner> 
            </D:lockinfo> 
            """
        val template = Template(text)
        val param = mapOf("href" to "/book/hello/world", "scope" to "exclusive", "type" to "write")
        val time = measureTimeMillis {
            repeat(100000) {
                template.fill(param)
            }
        }
        println(time)
    }

    @Test
    fun test4() {
        val text = """
            <?xml version="1.0" encoding="utf-8" ?> 
                <D:lockinfo xmlns:D="DAV:"> 
                    <D:locktype><D:%s/></D:locktype> 
                    <D:lockscope><D:%s/></D:lockscope> 
                <D:owner> 
                    <D:href>%s</D:href> 
                </D:owner> 
            </D:lockinfo> 
        """.trimIndent()
        val href = "/book/hello/world"
        val write = "write"
        val scope = "exclusive"
        val time = measureTimeMillis {
            repeat(100000) {
                text.format(write, scope, href)
            }
        }
        println(time)
    }

}
