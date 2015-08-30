class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(nums == null || nums.size() == 0){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        helper(res, nums, list);
        return res;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> nums, ArrayList<Integer> list){
        if(list.size() == nums.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0 ; i < nums.size(); i++){
            int val = nums.get(i);
            if(!list.contains(val)){
                list.add(val);
                helper(res, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
