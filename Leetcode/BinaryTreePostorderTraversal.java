public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    
    public void helper(List<Integer> res, TreeNode p){
        if (p != null) {
            helper(res, p.left);
            helper(res, p.right);
            res.add(p.val);
        }
    }
}

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode last = root;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur.left == last || cur.right == last || (cur.left == null && cur.right == null)) {
                res.add(cur.val);
                stack.pop();
                last = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return res;
    }
}

//Morris
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode dump = new TreeNode(0);;
        dump.left = root;
        TreeNode cur = dump, prev = null;
        while (cur!=null)
        {
            if (cur.left == null){
                cur = cur.right;
            }
            else{
                prev = cur.left;
                while (prev.right != null && prev.right != cur)
                    prev = prev.right;

                if (prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }
                else{
                    printReverse(cur.left, prev,res); 
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    } 
}
