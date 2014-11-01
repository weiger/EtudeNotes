import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

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
    public static ArrayList<LinkedList<TreeNode>> creatbyDFS(TreeNode root){
        ArrayList<LinkedList<TreeNode>> res = new ArrayList<>();
        dfs(res,root,0);
        return res;
    }
    public static void dfs(ArrayList<LinkedList<TreeNode>> res,TreeNode p,int level){
        if(p==null)
            return;
        LinkedList<TreeNode> list = null;
        if(res.size()==level){
            list = new LinkedList<TreeNode>();
            res.add(list);
        }else{
            list = res.get(level);
        }
        list.add(p);
        dfs(res,p.left,level+1);
        dfs(res,p.right,level+1);
    }
    public static ArrayList<LinkedList<TreeNode>> creatbyBFS(TreeNode root){
        ArrayList<LinkedList<TreeNode>> res = new ArrayList<>();
        if(root==null)
            return res;
        LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
        cur.add(root);
        while(!cur.isEmpty()){
            res.add(cur);
            LinkedList<TreeNode> prev = cur;
            cur = new LinkedList<TreeNode>();
            for(TreeNode e:prev){
                if(e.left!=null)
                    cur.add(e.left);
                if(e.right!=null)
                    cur.add(e.right);
            }
        }
        return res;
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
        
        ArrayList<LinkedList<TreeNode>> list1 = creatbyDFS(b1.root);
        printArrayList(list1);
        
        ArrayList<LinkedList<TreeNode>> list2 = creatbyBFS(b1.root);
        printArrayList(list2);
    }
    public static void printArrayList(ArrayList<LinkedList<TreeNode>> res){
        if(res==null)
            return;
        for(LinkedList<TreeNode> e:res){
            Iterator it = e.iterator();
            while(it.hasNext())
                System.out.print(((TreeNode)it.next()).val+"-> ");
            System.out.println();
        }
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
