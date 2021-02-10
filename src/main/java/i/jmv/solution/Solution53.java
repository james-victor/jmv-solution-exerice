package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;


/**
 * 53. 最大子序和
 */

public class Solution53 {

    @Test
    public void testMaxSubArray() {
        Assert.assertEquals(-2, maxSubArray(new int[]{-6, -2, -4 - 5, -6}));
        Assert.assertEquals(4, maxSubArray(new int[]{-6, 4, -2, -4 - 5, -6}));
    }

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) max = sum;
        }
        return max;
    }
}