/*
Given n unique integers, number k (1<=k<=n)  and target. Find all possible k integers where their sum is target.

Example
Given [1,2,3,4], k=2, target=5, [1,4] and [2,3] are possible solutions
*/

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A == null || A.length == 0)
            return res;
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(res,list,A,target,k,0,0);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,int[] A,int tar,int k,int sum,int pos){
        if(list.size() == k){
            if(tar == sum){
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for(int i = pos; i < A.length; i++){
            list.add(A[i]);
            helper(res,list,A,tar,k,sum + A[i],i + 1);
            list.remove(list.size() - 1);
        }
    }
}

