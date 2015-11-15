public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(helper(lower, upper));
            return res;
        }
        long prev = lower - 1;
        for (int i = 0; i < nums.length; i++) {
            long cur = nums[i];
            if (cur - prev > 1 && prev + 1 <= cur - 1) {
                res.add(helper(prev + 1, cur - 1));
            }
            prev = cur;
        }
        if (prev + 1 <= upper)
            res.add(helper(prev + 1, upper));
        return res;
    }
    public String helper(long beg, long end){
        if (beg == end) {
            return String.valueOf(beg);
        } else {
            return beg + "->" + end;
        }
    }
}

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(helper(lower, upper));
            return res;
        }
        long prev;
        if (nums[0] - lower > 0) {
            res.add(helper(lower, nums[0] - 1));
            prev = nums[0];
        } else {
            prev = lower;
        }
        for (int i = 0; i < nums.length; i++) {
            long cur = nums[i];
            if (cur - prev > 1) {
                res.add(helper(prev + 1, cur - 1));
            }
            prev = cur;
        }
        if (prev + 1 <= upper)
            res.add(helper(prev + 1, upper));
        return res;
    }
    public String helper(long beg, long end){
        if (beg == end) {
            return String.valueOf(beg);
        } else {
            return beg + "->" + end;
        }
    }
}
