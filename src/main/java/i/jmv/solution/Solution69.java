package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;


/**
 * 69. x 的平方根
 */
public class Solution69 {

    @Test
    public void testMySqrt() {
        Assert.assertEquals(46339, mySqrt(2147395599));
    }

//    public int mySqrt(int x) {
//        for (int sq = 1; sq <= x; sq++) {
//            if (sq * sq == x) {
//                return sq;
//            } else if (sq * sq > x) {
//                return sq - 1;
//            }
//        }
//        return x;
//    }


//    public int mySqrt(int x) {
//        int left = 0, right = x;
//
//        while (left <= right) {
//            long mid = left + (right - left) / 2;
//            if (mid * mid == x) {
//                return (int) mid;
//            } else if (mid * mid > x) {
//                right = (int) mid - 1;
//            } else {
//                left = (int) mid + 1;
//            }
//        }
//        return right;
//    }


    public int mySqrt(int x) {
        double pre = 0, cur = 1;
        while (Math.abs(pre - cur) >= 0.00001) {
            pre = cur;
            cur = (x + cur * cur) / (2 * cur);
        }
        return (int) pre;
    }
}