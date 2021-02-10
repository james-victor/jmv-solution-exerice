package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 3. Longest Substring Without Repeating Characters
 */
public class Solution3 {

    @Test
    public void testLengthOfLongestSubstring() {
        Assert.assertEquals(1, lengthOfLongestSubstring(" "));
        Assert.assertEquals(0, lengthOfLongestSubstring(""));
        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(1, lengthOfLongestSubstring("bb"));
        Assert.assertEquals(2, lengthOfLongestSubstring("au"));
        Assert.assertEquals(3, lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        byte[] bt = s.getBytes();
        Map<Byte, Integer> map = new HashMap<>();
        if (bt.length == 0)
            return 0;
        int len = 1;
        for (int i = 0; i < bt.length; i++) {
            if (map.containsKey(bt[i])) {
                int c = map.get(bt[i]) + 1;
                map.clear();
                for (int j = c; j <= i; j++) {
                    map.put(bt[j], j);
                }
            } else {
                map.put(bt[i], i);
            }
            if (len < map.size())
                len = map.size();
        }
        return len;
    }
}