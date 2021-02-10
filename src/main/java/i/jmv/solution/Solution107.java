package i.jmv.solution;

import i.jmv.solution.util.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 */
public class Solution107 {


    @Test
    public void testLevelOrderBottom() {
        List<List<Integer>> lsLs = levelOrderBottom(TreeNode.createTreeNode(new int[]{}));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> leftLs = levelOrderBottom(root.left);
        List<Integer> rightLs = null;
//        ls.add();
        return null;
    }
}