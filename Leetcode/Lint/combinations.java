/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
Example
For example,
If n = 4 and k = 2, a solution is:
[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
*/

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if(n == 0 || k == 0)
		    return res;
		List<Integer> list = new ArrayList<>();
		helper(res,list,n,k,1);
		return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> list,int n,int k,int pos){
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = pos;i <= n;i++){
            list.add(i);
            helper(res,list,n,k,i+1);
            list.remove(list.size() - 1);
        }
    }
}
