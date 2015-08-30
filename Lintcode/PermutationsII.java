class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(nums == null || nums.size() == 0){
            return res;
        }
        Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] rec = new boolean[nums.size()];
        helper(res, nums, list, rec);
        return res;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> nums, ArrayList<Integer> list, boolean[] rec){
        if(list.size() == nums.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0 ; i < nums.size(); i++){
            if(!rec[i]){
                rec[i] = true;
                list.add(nums.get(i));
                helper(res, nums, list, rec);
                list.remove(list.size() - 1);
                rec[i] = false;
                while(i + 1 < nums.size() && nums.get(i) == nums.get(i + 1)){
                    i++;
                }
            }
        }
    }
}

