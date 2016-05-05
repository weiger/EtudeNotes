public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;n--;
        while (n >= 0) {
            if (m >= 0) {
                if (nums1[m] >= nums2[n]) {
                    nums1[m + n + 1] = nums1[m--];
                } else {
                    nums1[m + n + 1] = nums2[n--];
                }
            } else {
                nums1[m + n + 1] = nums2[n--];
            }
        }
    }
}
