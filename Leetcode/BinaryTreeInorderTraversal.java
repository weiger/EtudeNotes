public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        helper(res, root);
        return res;
    }
    public void helper(List<Integer> res, TreeNode cur){
        if(cur != null) {
            helper(res, cur.left);
            res.add(cur.val);
            helper(res, cur.right);          
        }
    }
}

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}

//Morris
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode cur = root;
        while(cur != null) {
            if(cur.left != null) {
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur) 
                    prev = prev.right;
                if(prev.right == cur) {
                    result.add(cur.val);
                    cur = cur.right;
                    prev.right = null;
                } else {
                    prev.right = cur;
                    cur = cur.left;
                }
            } else {
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
