public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int beg = 0;
        int end = numbers.length - 1;
        while(beg < end) {
            int sum = numbers[beg] + numbers[end];
            if (sum == target) {
                return new int[]{beg + 1, end + 1};
            } else if (sum > target) {
                end--;
            } else if (sum < target) {
                beg++;
            }
        }
        return null;
    }
}