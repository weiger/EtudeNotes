public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		helper(res, list, n, k, 1);
		return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int pos){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = pos; i <= n; i++){
            list.add(i);
            helper(res, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
