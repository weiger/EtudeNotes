/*
Given a set of distinct integers, return all possible subsets.

Note
Elements in a subset must be in non-descending order.

The solution set must not contain duplicate subsets.

Example
If S = [1,2,3], a solution is:
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(S==null || S.size()==0)
            return res;
        Collections.sort(S);
        helper(res,list,S,0);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,ArrayList<Integer> S,int pos){
        res.add(new ArrayList<Integer>(list));
        for(int i=pos;i<S.size();i++){
            list.add(S.get(i));
            helper(res,list,S,i+1);
            list.remove(list.size()-1);
        }
    }
}
