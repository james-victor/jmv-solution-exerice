package i.jmv;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {

    /**
     * *********************************************************************************
     * 1. Two Sum
     */
    @Test
    public void testTwoSum() {
        Assert.assertArrayEquals(new int[]{0, 4}, twoSum(new int[]{1, 2, 5, 9, 8}, 9));
    }

    public int[] twoSum(int[] nums, int target) {
        int indexArrayMax = 9;
        int[] indexArrays = new int[indexArrayMax + 1];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            int index = diff & indexArrayMax;
            if (indexArrays[index] != 0) {
                return new int[]{indexArrays[index] - 1, i};
            }
            indexArrays[nums[i] & indexArrayMax] = i + 1;
        }
        throw new IllegalArgumentException("No two sum value");
    }

    /**
     * *********************************************************************************
     * 2. Add Two Numbers
     */
    @Test
    public void testAddTwoNumbers() {
        ListNode l1 = createListNode(new int[]{1, 2, 3});
        ListNode l2 = createListNode(new int[]{9, 7, 6, 9});
        printListNode(l1);
        printListNode(l2);
        printListNode(addTwoNumbers(l1, l2));
        // Assert.assertNull(addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode p1 = l1, p2 = l2;
        ListNode nh = new ListNode(0);
        ListNode np = nh;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int a = 0;
            int b = 0;
            if (p1 != null) {
                a = p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                b = p2.val;
                p2 = p2.next;
            }
            int sum = carry + a + b;
            carry = sum / 10;
            np = np.next = new ListNode(sum % 10);
        }
        if (carry > 0) {
            np.next = new ListNode(carry);
        }
        return nh.next;
    }

    public void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
        System.out.println();
    }

    /**
     * *********************************************************************************
     * 3. Longest Substring Without Repeating Characters
     */
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


    /**
     * *********************************************************************************
     * 7. Reverse Integer
     */
    @Test
    public void testReverse() {
        Assert.assertEquals(0, reverse(1534236469));
    }

    public int reverse(int x) {
        double y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        int imax = 2147483647;
        int imin = -2147483648;
        return (imax < y || imin > y) ? 0 : (int) y;
    }

    /**
     * *********************************************************************************
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


    /**
     * *********************************************************************************
     * 12. 整数转罗马数字
     */
    @Test
    public void testIntToRoman() {
        Assert.assertEquals("MM", intToRoman(2000));
    }

    private String getRomaTxt(int ch, int time) {
        int num = ch * time;
        if (time == 1000) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ch; i++) {
                sb.append("M");
            }
            return sb.toString();
        }
        switch (num) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 20:
                return "XX";
            case 30:
                return "XXX";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 60:
                return "LX";
            case 70:
                return "LXX";
            case 80:
                return "LXXX";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 200:
                return "CC";
            case 300:
                return "CCC";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 600:
                return "DC";
            case 700:
                return "DCC";
            case 800:
                return "DCCC";
            case 900:
                return "CM";
            case 1000:
                return "M";
        }
        return "";
    }

    public String intToRoman(int num) {
        int time = 1;
        int n = num;
        StringBuilder rs = new StringBuilder();
        while (n > 0) {
            rs.insert(0, getRomaTxt(num % 10, time));
            num = num / 10;
            time = time * 10;
            n = n / 10;
        }
        return rs.toString();
    }


    /**
     * *********************************************************************************
     * 13. 罗马数字转整数
     */
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


    /**
     * *********************************************************************************
     * 14. 最长公共前缀
     */
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

    /**
     * *********************************************************************************
     * 20. 有效的括号
     */
    @Test
    public void testIsValid() {
        Assert.assertTrue(isValid(""));
        Assert.assertFalse(isValid("[[[]]]]"));
        Assert.assertFalse(isValid("[[[[]]"));
        Assert.assertTrue(isValid("[]"));
        Assert.assertTrue(isValid("{[]}"));
        Assert.assertFalse(isValid("{[}]"));
        Assert.assertFalse(isValid("({[}])"));
        Assert.assertTrue(isValid("({[]})"));
        Assert.assertTrue(isValid("{{}[][[[]]]}"));
    }

    public boolean isValid(String s) {

        char[] chars = s.toCharArray();
        CharStack stack = new CharStack();
        for (char aChar : chars) {
            if (isLeftBrackets(aChar)) {
                stack.append(aChar);
            } else {
                if (stack.getChar() == antiBrackets(aChar))
                    stack.remove();
                else
                    stack.append(aChar);
            }
        }
        return stack.length() == 0;
    }

    private boolean isLeftBrackets(char c) {
        switch (c) {
            case '[':
            case '{':
            case '(':
                return true;
            default:
                return false;
        }
    }

    private char antiBrackets(char c) {
        switch (c) {
            case ']':
                return '[';
            case '}':
                return '{';
            case ')':
                return '(';
            default:
                return ' ';
        }
    }


    /**
     * *********************************************************************************
     * 21. 合并两个有序链表
     */
    @Test
    public void testMergeTwoLists() {
        ListNode listNode = mergeTwoLists(createListNode(new int[]{3}), createListNode(new int[]{0, 1, 4, 5, 7, 7, 7}));
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode l1i = l1;
//        ListNode l2i = l2;
//
//        ListNode tmpI = new ListNode();
//        ListNode head = tmpI;
//
//        while (l1i != null || l2i != null) {
//            if (tmpI.next == null) {
//                tmpI.next = new ListNode();
//                tmpI = tmpI.next;
//            }
//            if (l1i != null && l2i != null) {
//                if (l1i.val <= l2i.val) {
//                    tmpI.val = l1i.val;
//                    l1i = l1i.next;
//                } else {
//                    tmpI.val = l2i.val;
//                    l2i = l2i.next;
//                }
//            } else {
//                if (l1i != null) {
//                    tmpI.val = l1i.val;
//                    l1i = l1i.next;
//                }
//
//                if (l2i != null) {
//                    tmpI.val = l2i.val;
//                    l2i = l2i.next;
//                }
//            }
//        }
//
//        return head.next;
//    }


    /**
     * *********************************************************************************
     * 26. 删除排序数组中的重复项
     */
    @Test
    public void testRemoveDuplicates() {
        Assert.assertEquals(5, removeDuplicates(new int[]{1, 2, 3, 4, 5, 5, 5}));
        Assert.assertEquals(5, removeDuplicates(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(4, removeDuplicates(new int[]{2, 2, 2, 2, 3, 4, 4, 5}));
        Assert.assertEquals(5, removeDuplicates(new int[]{1, 2, 3, 3, 3, 3, 3, 4, 5}));
        Assert.assertEquals(0, removeDuplicates(new int[]{}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int point = 0;
        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[point] != nums[i]) {
                nums[++point] = nums[i];
                size++;
            }
        }
        return size;
    }


    /**
     * *********************************************************************************
     * 27. 移除元素
     */
    @Test
    public void testRemoveElement() {
        Assert.assertEquals(6, removeElement(new int[]{1, 2, 3, 4, 5, 5, 5}, 2));
        Assert.assertEquals(4, removeElement(new int[]{1, 2, 3, 4, 5}, 3));
        Assert.assertEquals(4, removeElement(new int[]{2, 2, 2, 2, 3, 4, 4, 5}, 2));
        Assert.assertEquals(4, removeElement(new int[]{1, 2, 3, 3, 3, 3, 3, 4, 5}, 3));
        Assert.assertEquals(9, removeElement(new int[]{1, 2, 3, 3, 3, 3, 3, 4, 5}, 9));
        Assert.assertEquals(4, removeElement(new int[]{0, 4, 4, 0, 4, 4, 4, 0, 2}, 4));
        Assert.assertEquals(0, removeElement(new int[]{}, 2));
    }

    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[p] = nums[i];
                p++;
            }
        }

        // System.out.println(Arrays.toString(nums));
        return p;
    }


    /**
     * *********************************************************************************
     * 28. 实现 strStr()
     */
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

    /**
     * *********************************************************************************
     * 35. 搜索插入位置
     */
    @Test
    public void testSearchInsert() {
        Assert.assertEquals(3, searchInsert(new int[]{1, 3, 4, 5}, 5));

    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target <= nums[0])
            return 0;
        if (target > nums[nums.length - 1])
            return nums.length;
        if (target == nums[nums.length - 1])
            return nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (target == nums[i])
                return i;
            if (nums[i] < target && target < nums[i + 1])
                return i + 1;
        }
        return 0;
    }


    /**
     * *********************************************************************************
     * 38. 外观数列
     */
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


    /**
     * *********************************************************************************
     * 53. 最大子序和
     */

    @Test
    public void testMaxSubArray() {
        Assert.assertEquals(-2, maxSubArray(new int[]{-6, -2, -4 - 5, -6}));
        Assert.assertEquals(4, maxSubArray(new int[]{-6, 4, -2, -4 - 5, -6}));
    }

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) max = sum;
        }
        return max;
    }

    /**
     * *********************************************************************************
     * 58. 最后一个单词的长度
     */
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

    /**
     * *********************************************************************************
     * 66. 加一
     */
    @Test
    public void testPlusOne() {
        Assert.assertArrayEquals(new int[]{1, 2, 4}, plusOne(new int[]{1, 2, 3}));
        Assert.assertArrayEquals(new int[]{1}, plusOne(new int[]{0}));
        Assert.assertArrayEquals(new int[]{1, 0}, plusOne(new int[]{9}));
        Assert.assertArrayEquals(new int[]{1, 0, 0}, plusOne(new int[]{9, 9}));
        Assert.assertArrayEquals(new int[]{1, 9, 9}, plusOne(new int[]{1, 9, 8}));
    }

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] oneMultiZero = new int[digits.length + 1];
        oneMultiZero[0] = 1;
        return oneMultiZero;
    }

    /**
     * *********************************************************************************
     * 67. 二进制求和
     */
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

    /**
     * *********************************************************************************
     * 69. x 的平方根
     */
    @Test
    public void testMySqrt() {
        Assert.assertEquals(46339, mySqrt(2147395599));
    }

//    public int mySqrt(int x) {
//        for (int sq = 1; sq <= x; sq++) {
//            if (sq * sq == x) {
//                return sq;
//            } else if (sq * sq > x) {
//                return sq - 1;
//            }
//        }
//        return x;
//    }


//    public int mySqrt(int x) {
//        int left = 0, right = x;
//
//        while (left <= right) {
//            long mid = left + (right - left) / 2;
//            if (mid * mid == x) {
//                return (int) mid;
//            } else if (mid * mid > x) {
//                right = (int) mid - 1;
//            } else {
//                left = (int) mid + 1;
//            }
//        }
//        return right;
//    }


    public int mySqrt(int x) {
        double pre = 0, cur = 1;
        while (Math.abs(pre - cur) >= 0.00001) {
            pre = cur;
            cur = (x + cur * cur) / (2 * cur);
        }
        return (int) pre;
    }

    /**
     * *********************************************************************************
     * 70. 爬楼梯
     */
    @Test
    public void testClimbStairs() {
        Assert.assertEquals(13, climbStairs(6));
    }

    public int climbStairs(int n) {
        if (n <= 3) return n;

        int prePre = 2;
        int pre = 3;
        int count = 0;

        for (int i = 3; i < n; i++) {
            count = prePre + pre;
            prePre = pre;
            pre = count;
        }
        return count;

    }

    /**
     * *********************************************************************************
     * 83. 删除排序链表中的重复元素
     */
    @Test
    public void testDeleteDuplicates() {
        ListNode listNode = deleteDuplicates(createListNode(new int[]{1, 2, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 6, 7}));
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }


    /**
     * *********************************************************************************
     * 88. 合并两个有序数组
     */
    @Test
    public void testMerge() {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        merge(new int[]{1}, 1, new int[]{}, 0);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        for (int i = m + n - 1, j = m - 1; j >= 0; i--, j--) {
            nums1[i] = nums1[j];
        }
        int p1 = 0, p2 = 0;
        for (int p0 = 0; p0 < m + n; p0++) {
            if (p1 >= m || p2 < n && nums2[p2] <= nums1[n + p1]) {
                nums1[p0] = nums2[p2];
                p2++;
            } else {
                if (p0 != n + p1) {
                    nums1[p0] = nums1[n + p1];
                    nums1[n + p1] = 0;
                }
                p1++;
            }
        }
    }


    /**
     * *********************************************************************************
     * 100. 相同的树
     */
    @Test
    public void testIsSameTree() {
        Assert.assertTrue(isSameTree(createTreeNode(new int[]{}), createTreeNode(new int[]{})));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            } else {
                return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
            }
        } else {
            return p == null && q == null;
        }
    }

    /**
     * *********************************************************************************
     * 101. 对称二叉树
     */
    @Test
    public void testIsSymmetric() {
        Assert.assertTrue(isSymmetric(createTreeNode(new int[]{})));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }


    /**
     * *********************************************************************************
     * 104. 二叉树的最大深度
     */
    @Test
    public void testMaxDepth() {
        Assert.assertEquals(1, maxDepth(createTreeNode(new int[]{})));
    }


    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * *********************************************************************************
     * 107. 二叉树的层次遍历 II
     */
    @Test
    public void testLevelOrderBottom() {
        List<List<Integer>> lsLs = levelOrderBottom(createTreeNode(new int[]{}));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> leftLs = levelOrderBottom(root.left);
        List<Integer> rightLs = null;
//        ls.add();
        return null;
    }

    /**
     * *********************************************************************************
     * 108. 将有序数组转换为二叉搜索树
     */
    @Test
    public void testSortedArrayToBST() {
        int[] nums = new int[]{-6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6};
        TreeNode treeNode = sortedArrayToBST(nums);
        printTreeNode(treeNode);
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        int center = nums.length / 2;
        TreeNode treeNode = new TreeNode(nums[center]);
        treeNode.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, center));
        treeNode.right = sortedArrayToBST(Arrays.copyOfRange(nums, center + 1, nums.length));
        return treeNode;
    }

    /**
     * *********************************************************************************
     * 171. Excel表列序号
     */
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


    /**
     * *********************************************************************************
     * 234. 回文链表
     */
    @Test
    public void testIsPalindromeListNode() {

    }

//    Stack<Integer> stack = new Stack<>();
//
//    public boolean isPalindrome(ListNode head) {
//
//        stack.push(head.val);
//        while (head.next!=null)
//        if ( stack.peek() == head.next.val){
//            stack.pop();
//        }
//    }
//
//    private

    /**
     * *********************************************************************************
     * 1002. 查找常用字符
     */
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



    /*
     * ****************************************************************************************************
     * 公共方法
     */

    /**
     * 创建链表数据
     *
     * @param arr 数组
     */
    private ListNode createListNode(int[] arr) {
        ListNode tmpI = new ListNode();
        ListNode head = tmpI;
        for (int value : arr) {
            tmpI.next = new ListNode(value);
            tmpI = tmpI.next;
        }
        return head.next;
    }


    /**
     * 创建链表数据
     *
     * @param arr 数组
     */
    private TreeNode createTreeNode(int[] arr) {
        return new TreeNode();
    }

    private void printTreeNode(TreeNode treeNode) {
        for (int i = 0; i < maxDepth(treeNode); i++) {
            printTreeNode(treeNode, i, 0);
            System.out.println();
        }
    }

    private void printTreeNode(TreeNode treeNode, int depth, int currDepth) {
        if (treeNode == null) {
            if (currDepth == depth) {
                System.out.print("nu\t");
            }
        } else {
            if (currDepth == depth) {
                System.out.print(treeNode.val + "\t");
            }
            currDepth++;
            printTreeNode(treeNode.left, depth, currDepth);
            printTreeNode(treeNode.right, depth, currDepth);
        }
    }


}


class CharStack {

    private StringBuilder sb = new StringBuilder();

    public void append(char c) {
        sb.append(c);
    }

    public void remove() {
        if (sb.length() != 0)
            sb.deleteCharAt(sb.length() - 1);
    }

    public char getChar() {
        return sb.length() != 0 ? sb.charAt(sb.length() - 1) : ' ';
    }

    public int length() {
        return sb.length();
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
}