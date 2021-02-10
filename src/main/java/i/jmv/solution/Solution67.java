package i.jmv.solution;

import org.junit.Assert;
import org.junit.Test;


/**
 * 67. 二进制求和
 */
public class Solution67 {

    @Test
    public void testaddBinary() {
        Assert.assertEquals("1001000", addBinary("101001", "11111"));
    }

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

//    public String addBinary(String a, String b) {
//        char[] charsA = a.toCharArray();
//        char[] charsB = b.toCharArray();
//
//        StringBuilder sb = new StringBuilder();
//        int ml = Math.max(charsA.length, charsB.length);
//        int carry = 0;
//
//        for (int p = 1; p <= ml; p++) {
//            int iA = 0;
//            int iB = 0;
//            if (p <= charsA.length && charsA[charsA.length - p] == '1') {
//                iA = 1;
//            }
//            if (p <= charsB.length && charsB[charsB.length - p] == '1') {
//                iB = 1;
//            }
//            int count = iA + iB + carry;
//            switch (count) {
//                case 0:
//                    sb.insert(0, 0);
//                    carry = 0;
//                    break;
//                case 1:
//                    sb.insert(0, 1);
//                    carry = 0;
//                    break;
//                case 2:
//                    sb.insert(0, 0);
//                    carry = 1;
//                    break;
//                case 3:
//                    sb.insert(0, 1);
//                    carry = 1;
//                    break;
//            }
//        }
//        if (carry == 1) {
//            sb.insert(0, 1);
//        }
//
//        return sb.toString();
//    }
}