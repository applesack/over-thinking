package xyz.scootaloo.thking.draft.dav

/**
 * @author flutterdash@qq.com
 * @since 2022/09/10 - 10:37
 */
class WriteLock(
    val isShared: Boolean,
    val owners: MutableList<Owner> = ArrayList()
) {
    fun isEmpty(): Boolean {
        return owners.isEmpty()
    }
}


class Owner(
    val username: String,
    var token: String,
    var timeout: Long
)


enum class LockMark {
    OK, LOCKED, INVALID
}


class LockResult(
    val mark: LockMark
)





