package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {
    
    @Test
    public void testTwoSum() {
        Assert.assertArrayEquals(new int[]{0, 4}, twoSum(new int[]{1, 2, 5, 9, 8}, 9));
    }

    public int[] twoSum(int[] nums, int target) {
        int indexArrayMax = 9;
        int[] indexArrays = new int[indexArrayMax + 1];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            int index = diff & indexArrayMax;
            if (indexArrays[index] != 0) {
                return new int[]{indexArrays[index] - 1, i};
            }
            indexArrays[nums[i] & indexArrayMax] = i + 1;
        }
        throw new IllegalArgumentException("No two sum value");
    }

}
