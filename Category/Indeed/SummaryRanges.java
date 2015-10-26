import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int start = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if ((long) cur - prev > 1) {
                res.add(helper(start, prev));
                start = cur;
            }
            prev = cur;
        }
        res.add(helper(start, prev));
        return res;
    }

    public String helper(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        } else {
            return start + "->" + end;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num1 = {1, 2, 3, 5, 6, 8};
        int[] num2 = {1, 2, 3, 3, 3, 5, 6, 8};
        System.out.println(s.summaryRanges(num1));
        System.out.println(s.summaryRanges(num2));
    }
}
