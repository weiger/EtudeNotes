import java.util.Arrays;

public class Solution {
    public static TreeNode creatMinimalBST(int[] A){
        return helper(A,0,A.length-1);
    }
    public static TreeNode helper(int[] A,int beg,int end){
        if(beg>end)
            return null;
        int mid = beg + (end-beg)/2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = helper(A,beg,mid-1);
        root.right = helper(A,mid+1,end);
        return root;
    }
    public static int[] removeDuplicate(int[] A){
        if(A.length<=1)
            return A;
        int index = 1;
        for(int i=1;i<A.length;i++){
            if(A[i]!=A[i-1])
                A[index++]=A[i];
        }
        int[] B = new int[index];
        for(int i=0;i<index;i++){
            B[i] = A[i];
        }
        return B;
    }
    public static void main(String[] args) {
        int[] A = new int[8];
        for(int i=0;i<A.length;i++){
            A[i] = (int)(Math.random()*20);
        }
        Arrays.sort(A);;
        A = removeDuplicate(A);
        BST b1 = new BST();
        b1.root = creatMinimalBST(A);
        b1.display();
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
                } else if(val == cur.val)
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
