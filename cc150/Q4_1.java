public class Solution {

/*    public static boolean isBalanced(TreeNode root) {
    if (root == null)
        return true;
    return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1
        && isBalance(root.left) && isBalance(root.right);
    }

    public static int getHeight(TreeNode p) {
    if (p == null)
        return 0;
    return 1 + Math.max(getHeight(p.left), getHeight(p.right));
}*/
public static boolean isBalanced(TreeNode root) {
    return getHeight(root)>-1;
}
public static int getHeight(TreeNode p){
    if(p==null)
        return 0;
    int left = getHeight(p.left);
    int right = getHeight(p.right);
    if(left<0 || right<0 || Math.abs(left-right)>1)
        return -1;
    return 1 + Math.max(left,right);
}
public static void main(String[] args) {
    BST b1 = new BST();
    b1.insert(20);b1.insert(10);b1.insert(30);b1.insert(40);b1.insert(50);
    b1.display();
    System.out.println("The tree is balance: " + isBalanced(b1.root));
}
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
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
                } else
                return;
            }
            if (val < trail.val) {
                trail.left = newnode;
            } else if (val > trail.val) {
                trail.right = newnode;
            }
        }
    }

    public String Serialization() {
        StringBuilder sb = new StringBuilder();
        SerialHelper(root, sb);
        return sb.toString();
    }

    public void SerialHelper(TreeNode p, StringBuilder sb) {
        if (p == null) {
            sb.append('#');
            return;
        } else {
            sb.append(p.val);
            SerialHelper(p.left, sb);
            SerialHelper(p.right, sb);
        }
    }

    public void Derialization(String str) {
        root = DerialHelper(str);
    }

    static int pos = 0;

    public TreeNode DerialHelper(String str) {
        if (str.charAt(pos) == '#')
            return null;
        else {
            TreeNode p = new TreeNode(Integer.parseInt(str.charAt(pos) + ""));
            pos++;
            p.left = DerialHelper(str);
            pos++;
            p.right = DerialHelper(str);
            return p;
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
