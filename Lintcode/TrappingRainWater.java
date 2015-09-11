public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length == 0)
            return 0;
        int len = heights.length;
        int[] left = new int[len];
        left[0] = 0;
        int max = heights[0];
        for (int i = 1; i < len; i++){
            left[i] = max;
            max = Math.max(max, heights[i]);
        }
        int[] right = new int[len];
        right[len - 1] = 0;
        max = heights[len - 1];
        for (int i = len - 2; i >= 0; i--){
            right[i] = max;
            max = Math.max(max, heights[i]);
        }
        int sum = 0;
        for (int i = 0 ; i < len; i++){
            if (Math.min(left[i], right[i]) > heights[i]){
                sum += Math.min(left[i], right[i]) - heights[i];
            }
        }
        return sum;
    }
}
