/*
 * Given a collection of candidate numbers (C) and a target number (T), find all 
 * unique combinations in 
 * C where the candidate numbers sums to T.

 * Each number in C may only be used once in the combination.

 * Note:

 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, � , ak) must be in non-descending order. 
 * (ie, a1 ? a2 ? � ? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 */
//Same as CombinationSum I except eliminate same numbers in array

public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(num==null || num.length==0)
            return res;
        Arrays.sort(num);
        dfs(res,list,0,num,target,0);
        return res;
    }
    public void dfs(List<List<Integer>> res,ArrayList<Integer> list,int sum,int[] num,int tar,int pos){
        if(sum>tar)
            return;
        if(sum==tar){
            res.add(new ArrayList<Integer>(list));
        }
        for(int i=pos;i<num.length;i++){
            list.add(num[i]);
            dfs(res,list,sum+num[i],num,tar,i+1);
            list.remove(list.size()-1);
            while(i<num.length-1 && num[i]==num[i+1]){
                i++;
            }
        }
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new  ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new  ArrayList<Integer>();
        Arrays.sort(num);
        dfs(res,list,num,target,0);
        return res;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] can, int tar, int pos){
        if(tar<0)
            return;
        if(tar==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=pos;i<can.length;i++){
            list.add(can[i]);
            dfs(res,list,can,tar-can[i],i+1);
            list.remove(list.size()-1);
            while(i<can.length-1 && can[i]==can[i+1])
                i++;
        }
    }
} 
 
 
 
public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(res, list, num, 0, 0, target);
        return res;
    }

    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list,
            int[] num, int pos, int sum, int target) {
        if(sum == target)
            res.add(new ArrayList<Integer>(list));
        if(sum < target) {
            for(int i = pos; i < num.length; i++) {
                if(i > pos && num[i] == num[i - 1])
                    continue;
                list.add(num[i]);
                dfs(res, list, num, i + 1, sum + num[i], target);
                list.remove(list.size() - 1);
            }
        }
    }
}
