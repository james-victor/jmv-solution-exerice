package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;


/**
 * 13. 罗马数字转整数
 */
public class Solution13 {

    @Test
    public void testRomanToInt() {
        Assert.assertEquals(1994, romanToInt("MCMXCIV"));
    }

    private int getNumValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            int sNum = getNumValue(s.charAt(i));
            if (i + 1 == s.length() || sNum >= getNumValue(s.charAt(i + 1))) {
                num = num + sNum;
            } else {
                num = num - sNum;
            }
        }
        return num;
    }

}