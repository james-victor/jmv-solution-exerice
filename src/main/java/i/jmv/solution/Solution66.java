package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;


/**
 * 66. 加一
 */
public class Solution66 {

    @Test
    public void testPlusOne() {
        Assert.assertArrayEquals(new int[]{1, 2, 4}, plusOne(new int[]{1, 2, 3}));
        Assert.assertArrayEquals(new int[]{1}, plusOne(new int[]{0}));
        Assert.assertArrayEquals(new int[]{1, 0}, plusOne(new int[]{9}));
        Assert.assertArrayEquals(new int[]{1, 0, 0}, plusOne(new int[]{9, 9}));
        Assert.assertArrayEquals(new int[]{1, 9, 9}, plusOne(new int[]{1, 9, 8}));
    }

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] oneMultiZero = new int[digits.length + 1];
        oneMultiZero[0] = 1;
        return oneMultiZero;
    }
}