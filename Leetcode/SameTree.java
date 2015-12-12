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
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode cur1 = q1.poll();
            TreeNode cur2 = q2.poll();
            if (cur1 == null && cur2 == null) continue;
            if (cur1 == null || cur2 == null || cur1.val != cur2.val) return false;
            q1.offer(cur1.left);
            q1.offer(cur1.right);
            q2.offer(cur2.left);
            q2.offer(cur2.right);
        }
        if (!q1.isEmpty() || !q2.isEmpty()) return false;
        return true;
    }
}

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(p);
        s2.push(q);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode cur1 = s1.pop();
            TreeNode cur2 = s2.pop();
            if (cur1 == null && cur2 == null) continue;
            if (cur1 == null || cur2 == null || cur1.val != cur2.val) return false;
            s1.push(cur1.left);
            s2.push(cur2.left);
            s1.push(cur1.right);
            s2.push(cur2.right);
        }
        if (!s1.isEmpty() || !s2.isEmpty()) return false;
        return true;
    }
}
