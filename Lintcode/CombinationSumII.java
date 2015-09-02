public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(num == null || num.length == 0) return res;
        Arrays.sort(num);
        List<Integer> list = new ArrayList<>();
        helper(res, list, num, target, 0, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int[] num, int target, int sum, int pos){
        if(sum > target){
            return;
        }
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = pos; i < num.length; i++){
            list.add(num[i]);
            helper(res, list, num, target, sum + num[i], i + 1);
            list.remove(list.size() - 1);
            while(i + 1 < num.length && num[i] == num[i + 1]){
                i++;
            }
        }
    }
}
