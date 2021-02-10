package i.jmv.solution;


import org.junit.Assert;
import org.junit.Test;

/**
 * 171. Excel表列序号
 */
public class Solution171 {


    @Test
    public void testTitleToNumber() {
        Assert.assertEquals(1, titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {
        int loc = 0;
        for (int i = s.length() - 1, p = 1; i >= 0; i--) {
            loc = loc + p * (s.charAt(i) - 'A' + 1);
            p = p * 26;
        }
        return loc;
    }
}