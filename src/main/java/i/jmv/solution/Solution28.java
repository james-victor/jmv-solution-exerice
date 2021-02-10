package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;


/**
 * 28. 实现 strStr()
 */
public class Solution28 {


    @Test
    public void testStrStr() {
        Assert.assertEquals(2, strStr("abcabc", "cab"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack == null || haystack.length() == 0) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            fr:
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int i1 = 0; i1 < needle.length(); i1++) {
                    if (i + i1 >= haystack.length()) return -1;
                    if (haystack.charAt(i + i1) != needle.charAt(i1)) break fr;
                }
                return i;
            }
        }
        return -1;
    }
}