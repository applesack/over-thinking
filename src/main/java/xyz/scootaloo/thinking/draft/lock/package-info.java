/**
 * <h2>webdav 锁实现草稿</h2>
 * <p>
 * 独占锁, 共享锁的实现, 以及锁的超时自动回收
 * <p>
 * https://fullstackplayer.github.io/WebDAV-RFC4918-CN/09-WebDAV%E7%9A%84HTTP%E6%96%B9%E6%B3%95.html#_9-10-5-%E9%94%81%E5%85%BC%E5%AE%B9%E6%80%A7%E8%A1%A8
 *
 * @author flutterdash@qq.com
 * @since 2022/09/07 - 9:53
 */
package xyz.scootaloo.thinking.draft.lock;
