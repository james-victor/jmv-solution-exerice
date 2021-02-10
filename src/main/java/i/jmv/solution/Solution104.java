package i.jmv.solution;


import i.jmv.solution.util.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 104. 二叉树的最大深度
 */
public class Solution104 {

    @Test
    public void testMaxDepth() {
        Assert.assertEquals(1, maxDepth(TreeNode.createTreeNode(new int[]{})));
    }


    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}