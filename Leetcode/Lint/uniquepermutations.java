/*
Given a list of numbers with duplicate number in it. Find all unique permutations.

Example
For numbers [1,2,2] the unique permutations are:

[

    [1,2,2],

    [2,1,2],

    [2,2,1]

]
*/
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(nums==null || nums.size()==0)
            return res;
        Collections.sort(nums);
        boolean[] rec = new boolean[nums.size()];
        ArrayList<Integer> list = new ArrayList<>();
        helper(res,list,nums,rec);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,ArrayList<Integer> nums,boolean[] rec ){
        if(list.size()==nums.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.size();i++){
            if(!rec[i]){
                rec[i] = true;
                list.add(nums.get(i));
                helper(res,list,nums,rec);
                list.remove(list.size()-1);
                rec[i] = false;
                while(i<nums.size()-1 && nums.get(i)==nums.get(i+1)){
                    i++;
                }
            }
        }
    }
}

