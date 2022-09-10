package xyz.scootaloo.thinking.draft.lock;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/07 - 10:19
 */
public class LockResult {

    /**
     * <h2>锁成功创建</h2>
     */
    private static final int ok = 200;

    /**
     * <h2>锁请求成功并导致新的文件被创建</h2>
     */
    private static final int created = 201;

    /**
     * 尝试对一个不存在的路径加锁, 但是这个路径的父路径是缺失的,
     * 而且服务器不会主动创建这且缺失的文件夹(缺失的文件夹可能不止一个);
     * <p>
     * <strong>符合以上条件时, 返回此状态码</strong>
     */
    private static final int conflict = 409;

    /**
     * <h2>因为目标位置已存在锁, 并且兼容性与新锁相冲突</h2>
     */
    private static final int locked = 423;

    /**
     * <h2>目标锁的路径上有不能通过的锁</h2>
     */
    private static final int notMatch = 412;

    public int code;

    public boolean succeed;

    public BaseLock lock;

}
