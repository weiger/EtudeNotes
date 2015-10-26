import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public boolean twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                return true;
            }
        }
        return false;
    }
    public boolean twoSum2(int[] nums, int target) {
        int beg = 0; int end = nums.length - 1;
        while (beg < end) {
            int sum = nums[beg] + nums[end];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                beg++;
            } else if (sum > target) {
                end--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {1,2,3,4,5,6};
        System.out.println(s.twoSum1(A, 7));
        System.out.println(s.twoSum2(A, 7));
    }
}
