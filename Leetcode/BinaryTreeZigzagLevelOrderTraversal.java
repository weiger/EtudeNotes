public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.offer(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            if (flag) {
                Collections.reverse(list);
            }
            flag = !flag;
            res.add(list);
            list = new ArrayList<>();
        }
        return res;
    }
}

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> curLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        boolean flag = false;
        curLevel.offer(root);
        while(!curLevel.isEmpty()){
            TreeNode cur = curLevel.poll();
            list.add(cur.val);
            if (cur.left != null) {
                nextLevel.offer(cur.left);
            }
            if (cur.right != null) {
                nextLevel.offer(cur.right);
            }
            if (curLevel.isEmpty()) {
                curLevel = nextLevel;
                nextLevel = new LinkedList<>();
                if (flag) {
                    Collections.reverse(list);
                }
                flag = !flag;
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }
}
