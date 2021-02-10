package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;


/**
 * 58. 最后一个单词的长度
 */
public class Solution58 {

    @Test
    public void testLengthOfLastWord() {
        Assert.assertEquals(0, lengthOfLastWord(""));
        Assert.assertEquals(11, lengthOfLastWord("fdaljfdlka fdjlsjfldsj"));
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else if (s.charAt(i) == ' ' && count != 0) {
                return count;
            }
        }
        return count;
    }
}