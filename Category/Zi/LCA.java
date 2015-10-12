public class Solution {
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    public TreeNode LCAwithParent1(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) {
            return p;
        } else if (p == null || q == null) {
            return null;
        }
        HashSet<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = p.parent;
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = q.parent;
        }
        return null;
    }

    public TreeNode LCAwithParent2(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) {
            return p;
        } else if (p == null || q == null) {
            return null;
        }
        HashSet<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = p.parent;
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = q.parent;
        }
        return null;
    }

    public TreeNode LCAwithParent3(TreeNode root, TreeNode p, TreeNode q){
        if (p == q) {
            return p;
        } else if (p == null || q == null) {
            return null;
        }
        int a = getLevel(p);
        int b = getLevel(q);
        if (a > b) {
            p = moveToSame(p, a - b);
        } else {
            q = moveToSame(q, b - a);
        }
        while (p != q && p != null && q != null) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }

    public static int getLevel(TreeNode p){
        int level = 0;
        while (p.parent != null) {
            level++;
            p = p.parent;
        }
        return level;
    }

    public TreeNode moveToSame(TreeNode p, int diff){
        for (int i = 0 ; i < diff; i++) {
            p = p.parent;
        }
        return p;
    }
}

class TreeNode {
    int val;
    TreeNode parent;
    TreeNode left;
    TreeNode right;
}
