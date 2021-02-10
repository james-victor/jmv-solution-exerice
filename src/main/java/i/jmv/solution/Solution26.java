package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;


/**
 * 26. 删除排序数组中的重复项
 */
public class Solution26 {

    @Test
    public void testRemoveDuplicates() {
        Assert.assertEquals(5, removeDuplicates(new int[]{1, 2, 3, 4, 5, 5, 5}));
        Assert.assertEquals(5, removeDuplicates(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(4, removeDuplicates(new int[]{2, 2, 2, 2, 3, 4, 4, 5}));
        Assert.assertEquals(5, removeDuplicates(new int[]{1, 2, 3, 3, 3, 3, 3, 4, 5}));
        Assert.assertEquals(0, removeDuplicates(new int[]{}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int point = 0;
        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[point] != nums[i]) {
                nums[++point] = nums[i];
                size++;
            }
        }
        return size;
    }

}