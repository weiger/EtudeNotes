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
 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        int curLevel = 1;
        int nextLevel = 0;
        int cnt = 0;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            list.add(cur.val);
            curLevel--;
            if(cur.left != null){
                queue.offer(cur.left);
                nextLevel++;
            }
            if(cur.right != null){
                queue.offer(cur.right);
                nextLevel++;
            }
            if(curLevel == 0){
                if(cnt % 2 == 1){
                    Collections.reverse(list);
                }
                cnt++;
                res.add(list);
                list = new ArrayList<>();
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return res;
    }
}
