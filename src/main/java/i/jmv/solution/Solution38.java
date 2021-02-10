package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;


/**
 * 38. 外观数列
 */
public class Solution38 {

    @Test
    public void testCountAndSay() {
        Assert.assertEquals("1", countAndSay(1));
        Assert.assertEquals("11", countAndSay(2));
        Assert.assertEquals("21", countAndSay(3));
        Assert.assertEquals("1211", countAndSay(4));
        Assert.assertEquals("111221", countAndSay(5));
        Assert.assertEquals("312211", countAndSay(6));
        Assert.assertEquals("13112221", countAndSay(7));
        Assert.assertEquals("1113213211", countAndSay(8));
        Assert.assertEquals("31131211131221", countAndSay(9));
        Assert.assertEquals("13211311123113112211", countAndSay(10));
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";

        String str = "1";

        for (int i = 1; i < n; i++) {
            str = countAndSayNumber(str);
        }

        return str;
    }

    private String countAndSayNumber(String str) {

        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        char startChar = chars[0];
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1) {
                sb.append(count).append(chars[i]);
            } else if (startChar != chars[i + 1]) {
                sb.append(count).append(chars[i]);
                count = 1;
                startChar = chars[i + 1];
            } else {
                count++;
            }
        }
        return sb.toString();
    }
}