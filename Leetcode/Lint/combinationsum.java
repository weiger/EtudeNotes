/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.


For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

Note
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example
given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3]
*/
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates==null || candidates.length==0)
            return res;
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        helper(res,list,candidates,target,0,0);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> list,int[] can,int tar,int pos,int sum){
        if(sum>tar)
            return;
        if(sum==tar){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=pos;i<can.length;i++){
            list.add(can[i]);
            helper(res,list,can,tar,i,sum+can[i]);
            list.remove(list.size()-1);
        }
    }
}
