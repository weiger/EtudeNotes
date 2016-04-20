public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int beg = 0; int end = height.length - 1;
        while (beg < end) {
            res = Math.max(res, (end - beg) * Math.min(height[beg], height[end]));
            if (height[beg] <= height[end]) {
                beg++;
            } else if (height[beg] > height[end]) {
                end--;
            }
        }
        return res;
    }
}