/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate 
numbers sums to T.Each number in C may only be used once in the combination.
Note
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example
For example, given candidate set 10,1,6,7,2,1,5 and target 8,
A solution set is: 
[1,7]
[1,2,5]
[2,6]
[1,1,6]
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(num == null || num.length == 0)
            return res;
        Arrays.sort(num);    
        List<Integer> list = new ArrayList<>();
        helper(res,list,num,target,0,0);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> list,int[] num,int tar,int sum,int pos){
        if(sum > tar)
            return;
        if(sum == tar){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = pos;i < num.length;i++){
            list.add(num[i]);
            helper(res,list,num,tar,sum + num[i],i+1);
            list.remove(list.size() - 1);
            while(i < num.length - 1 && num[i] == num[i + 1]){
                i++;
            }
        }
    }
}
