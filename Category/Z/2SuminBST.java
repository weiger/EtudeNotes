public class Solution {

    public boolean twoSumBST(TreeNode root, int target){
        BSTforwardIterator itf = new BSTforwardIterator(root);
        BSTbackwordIterator itb = new BSTbackwordIterator(root);
        int L = itf.next();
        int R = itb.next();
        while(itf.hasNext() && itb.hasNext()){
            int sum = L + R;
            if(L > R) break;
            if(sum == target) return true;
            else if(sum < target){
                L = itf.next();
            }else if(sum > target){
                R = itb.next();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BST b = new BST();
        b.insert(3);
        b.insert(2);
        b.insert(1);
        b.insert(4);
        b.insert(5);
        System.out.println(new Solution().twoSumBST(b.root(), 10));
    }
}

class BSTforwardIterator{
    TreeNode cur;
    Stack<TreeNode> stack;
    BSTforwardIterator(TreeNode root){
        cur = root;
        stack = new Stack<>();
    }

    public boolean hasNext(){
        return cur != null || !stack.isEmpty();
    }

    public int next(){
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }
}

class BSTbackwordIterator{
    TreeNode cur;
    Stack<TreeNode> stack;
    BSTbackwordIterator(TreeNode root){
        cur = root;
        stack = new Stack<>();
    }

    public boolean hasNext(){
        return cur != null || !stack.isEmpty();
    }

    public int next(){
        while(cur != null){
            stack.push(cur);
            cur = cur.right;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.left;
        return val;
    }
}

class BST{
    TreeNode root;
    BST(){
        root = null;
    }
    public TreeNode root(){
        return root;
    }

    public void insert(int val){
        if(root == null){
            root = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null){
            if(cur.val == val){
                return;
            }else if (val < cur.val) {
                pre = cur;
                cur = cur.left;
            }else if(val > cur.val){
                pre = cur;
                cur = cur.right;
            }
        }
        if(val < pre.val){
            pre.left = new TreeNode(val);
        }else{
            pre.right = new TreeNode(val);
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
