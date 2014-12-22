/*
Given a list of numbers that may has duplicate numbers, return all possible subsets
Note
Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.
Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.size() == 0)
            return res;
        Collections.sort(S);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(res,list,S,0);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,ArrayList<Integer> S,int pos){
        res.add(new ArrayList<>(list));
        for(int i = pos;i < S.size();i++){
            list.add(S.get(i));
            helper(res,list,S,i+1);
            list.remove(list.size()-1);
            while(i < S.size() - 1 && S.get(i) == S.get(i+1)){
                i++;
            }
        }
    }
}

