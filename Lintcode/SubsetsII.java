class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(S == null || S.size() == 0){
            return res;
        }
        Collections.sort(S);
        ArrayList<Integer> list = new ArrayList<>();
        helper(res, S, list, 0);
        return res;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> S, ArrayList<Integer> list, int pos){
        res.add(new ArrayList<>(list));
        for(int i = pos; i < S.size(); i++){
            list.add(S.get(i));
            helper(res, S, list, i + 1);
            list.remove(list.size() - 1);
            while(i + 1 < S.size() && S.get(i) == S.get(i + 1)){
                i++;
            }
        }
    }
}

