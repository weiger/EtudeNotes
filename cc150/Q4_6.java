
public class Solution {
    public static void main(String[] args) {
        BST b1 = new BST();
        for(int i=0;i<10;i++){
            b1.insert((int)(Math.random()*20));
        }
        b1.display();
        TreeNode next = inorderSucc(b1.root.left);
        if(next!=null)
            System.out.println(next.val);
    }
    public static TreeNode inorderSucc(TreeNode p){
        if(p==null)
            return null;
        if(p.right!=null){
            TreeNode q = p.right;
            while(q.left!=null){
                q = q.left;
            }
            return q;
        }else{
            TreeNode q = p.parent;
            while(q!=null && q.left!=p){
                p = q;
                q = q.parent;
            }
            return q;
        }
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
        parent = null;
    }
}

class BST {
    public TreeNode root;

    BST() {
        root = null;
    }

    public void insert(int val) {
        TreeNode newnode = new TreeNode(val);
        if (root == null) {
            root = newnode;
        } else {
            TreeNode cur = root;
            TreeNode trail = null;
            while (cur != null) {
                if (val < cur.val) {
                    trail = cur;
                    cur = cur.left;
                } else if (val > cur.val) {
                    trail = cur;
                    cur = cur.right;
                } else if(val == cur.val)
                return;
            }
            if (val < trail.val) {
                trail.left = newnode;
                newnode.parent = trail;
            } else if (val > trail.val) {
                trail.right = newnode;
                newnode.parent = trail;
            }
        }
    }
    public void display() {
        final int height = 5, width = 64;

        int len = width * height * 2 + 2;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 1; i <= len; i++)
            sb.append(i < len - 2 && i % width == 0 ? "\n" : ' ');

        displayR(sb, width / 2, 1, width / 4, width, root, " ");
        System.out.println(sb);
    }

    private void displayR(StringBuilder sb, int c, int r, int d, int w,
        TreeNode n, String edge) {
        if (n != null) {
            displayR(sb, c - d, r + 2, d / 2, w, n.left, " /");

            String s = String.valueOf(n.val);
            int idx1 = r * w + c - (s.length() + 1) / 2;
            int idx2 = idx1 + s.length();
            int idx3 = idx1 - w;
            if (idx2 < sb.length())
                sb.replace(idx1, idx2, s).replace(idx3, idx3 + 2, edge);

            displayR(sb, c + d, r + 2, d / 2, w, n.right, "\\ ");
        }
    }
}
