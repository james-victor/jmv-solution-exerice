package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;


/**
 * 14. 最长公共前缀
 */
public class Solution14 {

    @Test
    public void testLongestCommonPrefix() {
        Assert.assertEquals("", longestCommonPrefix(new String[]{"aba", "aab", ""}));
        Assert.assertEquals("", longestCommonPrefix(new String[]{"", "aab", "aaa"}));
        Assert.assertEquals("a", longestCommonPrefix(new String[]{"a"}));
        Assert.assertEquals("", longestCommonPrefix(new String[]{}));
        Assert.assertEquals("", longestCommonPrefix(new String[]{"caa", "", "a", "acb"}));
        Assert.assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        int minLen = strs[0].length();
        StringBuilder sb = new StringBuilder();
        outer:
        for (int i = 0; i < minLen; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j + 1].length() < i + 1) {
                    return sb.toString();
                }
                if (strs[j + 1].length() < minLen) {
                    minLen = strs[j + 1].length();
                }
                if (strs[j].charAt(i) != strs[j + 1].charAt(i))
                    break outer;
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();

    }
}