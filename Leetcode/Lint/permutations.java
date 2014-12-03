/*
Given a list of numbers, return all possible permutations.

Example
For nums [1,2,3], the permutaions are: 
    [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(nums==null || nums.size()==0)
            return res;
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(res,list,nums);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,ArrayList<Integer> nums){
        if(list.size()==nums.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.size();i++){
            if(!list.contains(nums.get(i))){
                list.add(nums.get(i));
                helper(res,list,nums);
                list.remove(list.size()-1);
            }
        }
    }
}

