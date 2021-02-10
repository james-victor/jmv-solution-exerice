package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;


/**
 * 35. 搜索插入位置
 */
public class Solution35 {

    @Test
    public void testSearchInsert() {
        Assert.assertEquals(3, searchInsert(new int[]{1, 3, 4, 5}, 5));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target <= nums[0])
            return 0;
        if (target > nums[nums.length - 1])
            return nums.length;
        if (target == nums[nums.length - 1])
            return nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (target == nums[i])
                return i;
            if (nums[i] < target && target < nums[i + 1])
                return i + 1;
        }
        return 0;
    }
}