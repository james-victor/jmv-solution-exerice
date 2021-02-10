package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;


/**
 * 27. 移除元素
 */
public class Solution27 {

    @Test
    public void testRemoveElement() {
        Assert.assertEquals(6, removeElement(new int[]{1, 2, 3, 4, 5, 5, 5}, 2));
        Assert.assertEquals(4, removeElement(new int[]{1, 2, 3, 4, 5}, 3));
        Assert.assertEquals(4, removeElement(new int[]{2, 2, 2, 2, 3, 4, 4, 5}, 2));
        Assert.assertEquals(4, removeElement(new int[]{1, 2, 3, 3, 3, 3, 3, 4, 5}, 3));
        Assert.assertEquals(9, removeElement(new int[]{1, 2, 3, 3, 3, 3, 3, 4, 5}, 9));
        Assert.assertEquals(4, removeElement(new int[]{0, 4, 4, 0, 4, 4, 4, 0, 2}, 4));
        Assert.assertEquals(0, removeElement(new int[]{}, 2));
    }

    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[p] = nums[i];
                p++;
            }
        }

        // System.out.println(Arrays.toString(nums));
        return p;
    }
}