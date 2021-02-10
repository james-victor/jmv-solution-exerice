package i.jmv.solution;

import i.jmv.solution.util.TreeNode;
import org.junit.Assert;
import org.junit.Test;


/**
 * 100. 相同的树
 */
public class Solution100 {

    @Test
    public void testIsSameTree() {
        Assert.assertTrue(isSameTree(TreeNode.createTreeNode(new int[]{}), TreeNode.createTreeNode(new int[]{})));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            } else {
                return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
            }
        } else {
            return p == null && q == null;
        }
    }
}