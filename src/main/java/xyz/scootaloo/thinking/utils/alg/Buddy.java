package xyz.scootaloo.thinking.utils.alg;

import xyz.scootaloo.thinking.utils.mark.Mark;

/**
 * @author AppleSack
 * @since 2023/03/19
 */
@Mark("todo")
public class Buddy {

    private final FreeMemoryManager fmm;

    public Buddy(long size) {
        checkSize(size);
        fmm = new FreeMemoryManager(size);
    }

    /**
     * 向系统内申请一片内存, 如果申请成功, 那么返回一个Region对象, 如果申请失败, 返回null
     *
     * @param need 需要的内存大小
     * @return Region对象
     */
    public Region alloc(long need) {
        return null;
    }

    /**
     * 释放一片内存空间
     *
     * @param region 需要被释放的内存
     */
    public void free(Region region) {
    }

    private void checkSize(long size) {

    }

    record Region(int offset, int size) {
    }

    private static class FreeMemoryManager {

        private final FreeMemoryNode[] nodes;

        public FreeMemoryManager(long size) {
            // 16 -> 1 2 4 6 8 16
            long copy = size;
            int len = 1;
            while (copy > 1) {
                copy = copy >> 1;
                len++;
            }
            nodes = new FreeMemoryNode[len];
            nodes[len - 1] = new FreeMemoryNode();
        }



    }

    private static class FreeMemoryNode {
        int            size;
        int            offset;
        FreeMemoryNode prev, next;
    }

}
