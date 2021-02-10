package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;

/**
 * 7. Reverse Integer
 */
public class Solution7 {

    @Test
    public void testReverse() {
        Assert.assertEquals(0, reverse(1534236469));
    }

    public int reverse(int x) {
        double y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        int imax = 2147483647;
        int imin = -2147483648;
        return (imax < y || imin > y) ? 0 : (int) y;
    }
}