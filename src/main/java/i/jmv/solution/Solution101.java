package i.jmv.solution;

import i.jmv.solution.util.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 101. 对称二叉树
 */
public class Solution101 {

    @Test
    public void testIsSymmetric() {
        Assert.assertTrue(isSymmetric(TreeNode.createTreeNode(new int[]{})));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }
}

