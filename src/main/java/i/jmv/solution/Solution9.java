package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;

public class Solution9 {

    /**
     *
     * 9. Palindrome Number
     */
    @Test
    public void testIsPalindrome() {
        Assert.assertFalse(isPalindrome(-123321));
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        int b = x;
        int y = 0;
        while (b != 0) {
            y = y * 10 + b % 10;
            b = b / 10;
        }
        return y == x;
    }
}