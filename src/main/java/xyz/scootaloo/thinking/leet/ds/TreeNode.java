package xyz.scootaloo.thinking.leet.ds;

/**
 * @author flutterdash@qq.com
 * @since 2022/08/30 - 10:23
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode(" + val + ')';
    }

}
