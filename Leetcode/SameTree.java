/*
 * Given two binary trees, write a function to check if they are equal or not.

 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value. 
 */
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val==q.val)
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        else
            return false;
    }
}

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null && q != null || p != null && q == null || p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode q1 = queue1.poll();
            TreeNode q2 = queue2.poll();
            if (q1 == null && q2 == null) {
                continue;
            } else if (q1 == null || q2 == null) {
                return false;
            } else if (q1.val != q2.val) {
                return false;
            }
            queue1.offer(q1.left);
            queue2.offer(q2.left);
            queue1.offer(q1.right);
            queue2.offer(q2.right);
        }
        if (!queue1.isEmpty() || !queue2.isEmpty()) {
            return false;
        }
        return true;
    }
}
