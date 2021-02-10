package i.jmv.solution;


import org.junit.Assert;
import org.junit.Test;

/**
 * 70. 爬楼梯
 */
public class Solution70 {

    @Test
    public void testClimbStairs() {
        Assert.assertEquals(13, climbStairs(6));
    }

    public int climbStairs(int n) {
        if (n <= 3) return n;

        int prePre = 2;
        int pre = 3;
        int count = 0;

        for (int i = 3; i < n; i++) {
            count = prePre + pre;
            prePre = pre;
            pre = count;
        }
        return count;

    }
}