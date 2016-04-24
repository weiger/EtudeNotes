public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i< nums.length - 2; i++) {
            int beg = i + 1; int end = nums.length - 1;
            while (beg < end) {
                sum = nums[i] + nums[beg] + nums[end];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);list.add(nums[beg]);list.add(nums[end]);
                    res.add(list);
                    while(beg < end && nums[beg] == nums[beg + 1]){
                        beg++;
                    }
                    while(beg < end && nums[end] == nums[end - 1]){
                        end--;
                    }
                    beg++;end--;
                } else if (sum < 0) {
                    beg++;
                } else if (sum > 0) {
                    end--;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }
}