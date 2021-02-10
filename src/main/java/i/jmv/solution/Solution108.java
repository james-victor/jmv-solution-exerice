package i.jmv.solution;


import i.jmv.solution.util.TreeNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class Solution108 {


    @Test
    public void testSortedArrayToBST() {
        int[] nums = new int[]{-6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6};
        TreeNode treeNode = sortedArrayToBST(nums);
        TreeNode.printTreeNode(treeNode);
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        int center = nums.length / 2;
        TreeNode treeNode = new TreeNode(nums[center]);
        treeNode.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, center));
        treeNode.right = sortedArrayToBST(Arrays.copyOfRange(nums, center + 1, nums.length));
        return treeNode;
    }
}