public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int len = costs.length;
        int k = costs[0].length;
        int min1 = 0;
        int min2 = 0;
        int[] rec = new int[k];
        for (int i = 0 ; i < len; i++) {
            int oldmin1 = min1;
            int oldmin2 = min2;
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (rec[j] != oldmin1 || oldmin1 == oldmin2) {
                    rec[j] = costs[i][j] + oldmin1;
                } else {
                    rec[j] = costs[i][j] + oldmin2;
                }
                if (min1 <= rec[j]) {
                    min2 = Math.min(min2, rec[j]);
                } else {
                    min2 = min1;
                    min1 = rec[j];
                }
            }
        }
        return min1;
    }
}
