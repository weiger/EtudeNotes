public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<>(list));
        for(int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
            while(i < nums.length - 1 && nums[i] == nums[i + 1]){
                i++;
            }
        }
    }
}