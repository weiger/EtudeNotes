public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0 ; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] helper = new int[nums.length + 1];
        helper[0] = Integer.MIN_VALUE;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > helper[k]) {
                helper[++k] = nums[i];
            } else {
                int beg = 0;
                int end = k - 1;
                while (beg <= end) {
                    int mid = beg + (end - beg) / 2;
                    if (nums[i] > helper[mid]) {
                        beg = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                helper[beg] = nums[i];
            }
        }
        return k;
    }
}
