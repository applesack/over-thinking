package xyz.scootaloo.thking.draft.dav

import java.util.ListResourceBundle

/**
 * @author flutterdash@qq.com
 * @since 2022/09/10 - 10:36
 */
object Utils {

    fun split(path: String, delimiter: Char = '/'): List<String> {
        return path.split(delimiter).filter { it.isNotBlank() }
    }

}
