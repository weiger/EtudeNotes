public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res, nums, new ArrayList<>(), 0);
        return res;
    }
    public void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int pos){
        res.add(new ArrayList<>(list));
        for(int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            helper(res, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}