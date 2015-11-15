public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        long start = nums[0]; long prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long cur = nums[i];
            if (cur - prev > 1) {
                res.add(helper(start, prev));
                start = cur;
            }
            prev = cur;
        }
        res.add(helper(start, prev));
        return res;
    }
    public String helper(long start, long end){
        if (start == end) {
            return String.valueOf(start);
        } else {
            return start + "->" + end;
        }
    }
}
