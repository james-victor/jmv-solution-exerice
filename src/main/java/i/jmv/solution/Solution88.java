package i.jmv.solution;


import org.junit.Test;

/**
 * 88. 合并两个有序数组
 */
public class Solution88 {

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
}