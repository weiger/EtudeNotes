import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] A = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        System.out.println(magicIndex1(A));
        System.out.println(magicIndex2(A, 0, A.length - 1));
        int[] B = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println(magicIndex3(B, 0, B.length - 1));
    }

    public static int magicIndex1(int[] nums){
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int beg = 0; int end = nums.length - 1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            if (mid == nums[mid]) {
                return mid;
            } else if (mid < nums[mid]) {
                end = mid - 1;
            } else if (mid > nums[mid]) {
                beg = mid + 1;
            }
        }
        return -1;
    }
    public static int magicIndex2(int[] nums, int beg, int end){
        if (beg > end) return -1;
        int mid = beg + (end - beg) / 2;
        if (mid == nums[mid]) {
            return mid;
        } else if (mid < nums[mid]) {
            return magicIndex2(nums, beg, mid - 1);
        } else if (mid > nums[mid]) {
            return magicIndex2(nums, mid + 1, end);
        }
        return -1;
    }
    public static int magicIndex3(int[] nums, int beg, int end){
        if (beg > end) return -1;
        int midIndex = beg + (end - beg) / 2;
        int midValue = nums[midIndex];
        if (midIndex == midValue) {
            return midIndex;
        }
        int leftIndex = Math.min(midIndex - 1, midValue);
        int L = magicIndex3(nums, beg, leftIndex);
        if (L >= 0) return L;
        int rightIndex = Math.max(midIndex + 1, midValue);
        int R = magicIndex3(nums, rightIndex, end);
        if (R >= 0) return R;
        return -1;
    }
}
