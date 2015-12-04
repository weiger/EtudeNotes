public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, 2, n);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, int start, int end){
        if (end == 1 && list.size() > 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= end; i++) {
            if (end % i == 0) {
                list.add(i);
                helper(res, list, i, end / i);
                list.remove(list.size() - 1);
            }
        }
    }
}
