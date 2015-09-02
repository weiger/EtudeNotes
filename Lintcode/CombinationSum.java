public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        helper(res, list, candidates, target, 0, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int[] can, int target, int sum, int pos){
        if(sum > target){
            return;
        }
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = pos; i < can.length; i++){
            list.add(can[i]);
            helper(res, list, can, target, sum + can[i], i);
            list.remove(list.size() - 1);
        }
    }
}
