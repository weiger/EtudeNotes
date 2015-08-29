/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such 
 * that a + b + c + d = target? Find all unique quadruplets in the array which 
 * gives the sum of target.

 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, 
 * a <= b <= c <= d)
 * The solution set must not contain duplicate quadruplets.
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 * 
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int beg = j + 1;
                int end = nums.length - 1;
                while(beg < end){
                    int sum = nums[i] + nums[j] + nums[beg] + nums[end];
                    if(sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);list.add(nums[j]);
                        list.add(nums[beg]);list.add(nums[end]);
                        res.add(list);
                        while(beg + 1 < end && nums[beg] == nums[beg + 1]){
                            beg++;
                        }
                        while(end - 1 >= 0 && nums[end] == nums[end - 1]){
                            end--;
                        }
                        beg++;end--;
                    }else if(sum < target){
                        beg++;
                    }else if(sum > target){
                        end--;
                    }
                }
                while(j + 1 < nums.length && nums[j] == nums[j + 1]){
                    j++;
                }
            }
            while(i + 1 < nums.length && nums[i] == nums[i + 1]){
                i++;
            }
        }
        return res;
    }
}

