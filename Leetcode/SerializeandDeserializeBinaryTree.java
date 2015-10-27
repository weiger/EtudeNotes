/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        sb.append(root.val);
        int curLevel = 1;
        int nextLevel = 0;
        while (!q.isEmpty()) {
            for(int i = 0; i < curLevel; i++){
                TreeNode cur = q.poll();
                sb.append(" ");
                if (cur.left != null) {
                    sb.append(cur.left.val);
                    q.offer(cur.left);
                    nextLevel++;
                } else {
                    sb.append("#");
                }
                sb.append(" ");
                if (cur.right != null) {
                    sb.append(cur.right.val);
                    q.offer(cur.right);
                    nextLevel++;
                } else {
                    sb.append("#");
                }
            }
            curLevel = nextLevel;
            nextLevel = 0;
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("#")) {
            return null;
        }
        int idx = 0;
        String[] strs = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(strs[idx++]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int curLevel = 1;
        int nextLevel = 0;
        while (!q.isEmpty() && idx < data.length()) {
            for (int i = 0 ; i < curLevel; i++) {
                TreeNode cur = q.poll();
                if (strs[idx].equals("#")) {
                    cur.left = null;
                } else {
                    cur.left = new TreeNode(Integer.parseInt(strs[idx]));
                    q.offer(cur.left);
                    nextLevel++;
                }
                idx++;
                if (strs[idx].equals("#")) {
                    cur.right = null;
                } else {
                    cur.right = new TreeNode(Integer.parseInt(strs[idx]));
                    q.offer(cur.right);
                    nextLevel++;
                }
                idx++;
            }
            curLevel = nextLevel;
            nextLevel = 0;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
