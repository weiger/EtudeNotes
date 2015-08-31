/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        int curlevel = 1;
        int nextlevel = 0;
        while(!q.isEmpty()){
            for(int i = 0 ; i < curlevel; i++){
                TreeNode cur = q.poll();
                sb.append(" ");
                if(cur.left != null){
                    sb.append(cur.left.val);
                    nextlevel++;
                    q.offer(cur.left);
                }else{
                    sb.append("#");
                }
                sb.append(" ");
                if(cur.right != null){
                    sb.append(cur.right.val);
                    q.offer(cur.right);
                    nextlevel++;
                }else{
                    sb.append("#");
                }
            }
            curlevel = nextlevel;
            nextlevel = 0;
        }
        return sb.toString();
    }
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        if (data == null || data.equals("#") || data.isEmpty()) {
            return root;
        }
        String[] arr = data.split(" ");
        int idx = 0;
        root = new TreeNode(Integer.parseInt(arr[idx]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        idx++;
        int curlevel = 1;
        int nextlevel = 0;
        while (!q.isEmpty() && idx < arr.length) {
            for (int i = 0; i < curlevel; i++) {
                TreeNode cur = q.poll();
                if (arr[idx].equals("#")) {
                    cur.left = null;
                } else {
                    cur.left = new TreeNode(Integer.parseInt(arr[idx]));
                    nextlevel++;
                    q.offer(cur.left);
                }
                idx++;
                if (arr[idx].equals("#")) {
                    cur.right = null;
                } else {
                    cur.right = new TreeNode(Integer.parseInt(arr[idx]));
                    nextlevel++;
                    q.offer(cur.right);
                }
                idx++;
            }
            curlevel = nextlevel;
            nextlevel = 0;
        }
        return root;
    }
}

