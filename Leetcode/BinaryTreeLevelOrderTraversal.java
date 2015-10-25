/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 * For example:
 * Given binary tree {3,9,20,#,#,15,7},

 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:

 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ] 
 /**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> cur = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        cur.offer(root);
        while (!cur.isEmpty()) {
            TreeNode curNode = cur.poll();
            list.add(curNode.val);
            if (curNode.left != null) {
                next.offer(curNode.left);
            }
            if (curNode.right != null) {
                next.offer(curNode.right);
            }
            if (cur.isEmpty()) {
                res.add(list);
                list = new ArrayList<>();
                cur = next;
                next = new LinkedList<>();
            }
        }
        return res;
    } 
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    public void dfs(TreeNode p, List<List<Integer>> res, int level){
        if(p == null)
            return;
        if(level == res.size()){
            res.add(new ArrayList<>());
        }
        res.get(level).add(p.val);
        dfs(p.left, res, level + 1);
        dfs(p.right, res, level + 1);
    }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0 ; i < size; i++) {
                TreeNode cur = q.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(list);
            list = new ArrayList<>();
        }
        return res;
    } 
}
