package i.jmv.solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 1002. 查找常用字符
 */
public class Solution1002 {

    @Test
    public void testCommonChars() {
//        List<String> expected = commonChars(new String[]{"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"});
        List<String> expected = commonChars(new String[]{"bella", "label", "roller"});
        for (String str : expected) {
            System.out.println(str);
        }
    }

    public List<String> commonChars(String[] A) {
        //先得到第一个字符串里面每个字符的情况
        int[] charCount = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            charCount[A[0].charAt(i) - 'a']++;
        }

        //从第1个开始逐个进行比较
        for (int i = 1; i < A.length; i++) {
            int[] curCount = new int[26];

            //遍历第i个字符串
            for (int j = 0; j < A[i].length(); j++) {
                curCount[A[i].charAt(j) - 'a']++;
            }

            for (int k = 0; k < A[i].length(); k++) {
                curCount[A[i].charAt(k) - 'a'] = Math.min(charCount[A[i].charAt(k) - 'a'], curCount[A[i].charAt(k) - 'a']);
            }
            charCount = curCount;
        }

        //此时的charCount即为所有的字符串出现的共有的最小元素的个数
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (charCount[i] != 0) {
                result.add(String.valueOf((char) (i + 'a')));
                charCount[i]--;
            }
        }

        return result;
    }


}

