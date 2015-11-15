public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        helper(res, root, root.val + "");
        return res;
    }
    
    public void helper(List<String> res, TreeNode p, String str){
        if(p.left == null && p.right == null){
            res.add(str);
            return;
        }
        if(p.left != null) helper(res, p.left, str + "->" + p.left.val);
        if(p.right != null) helper(res, p.right, str + "->" + p.right.val);
    }
}

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        StringBuilder sb = new StringBuilder();
        TreeNode cur = root;
        TreeNode pre = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        sb.append(cur.val);

        while(cur.left != null){
            stack.push(cur.left);
            sb.append("->" + cur.left.val);
            cur = cur.left;
        }

        while(!stack.isEmpty()){
            if(stack.peek().left == null && stack.peek().right == null){
                res.add(sb.toString());
            }
            if(stack.peek().right == null || stack.peek().right == pre){
                pre = stack.pop();
                SBpop(sb);
            }else{
                cur = stack.peek().right;
                while(cur != null){
                    stack.push(cur);
                    sb.append("->" + cur.val);
                    cur = cur.left;
                }
            }
        }
        return res;
    }

    public void SBpop(StringBuilder sb){
        int idx = 0;
        for(int i = sb.length() - 1 ; i >= 0; i--) {
            if (sb.charAt(i) == '-' && sb.charAt(i + 1) == '>') {
                idx = i;
                break;
            }
        }
        sb.setLength(idx);
    }
}
