public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        helper(root, res, new ArrayList<>(), 0, sum);
        return res;
    }
    public void helper(TreeNode p, List<List<Integer>> res, List<Integer> list, int sum, int target){
        if (p == null) {
            return;
        }
        list.add(p.val);
        sum += p.val;
        if (p.left == null && p.right == null && sum == target) {
            res.add(new ArrayList<>(list));
        }
        helper(p.left, res, list, sum, target);
        helper(p.right, res, list, sum, target);
        list.remove(list.size() - 1);
    }
}

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        helper(res, new ArrayList<>(), root, sum);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> list, TreeNode p, int sum){
        if(p == null)
            return;
        if(p.val == sum && p.left == null && p.right == null){
            list.add(p.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(p.val);
        helper(res, list, p.left, sum - p.val);
        helper(res, list, p.right, sum - p.val);
        list.remove(list.size() - 1);
    }
}
