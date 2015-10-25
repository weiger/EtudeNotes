/*
 * Follow up for problem "Populating Next Right Pointers in Each Node".

 * What if the given tree could be any binary tree? Would your previous solution still work?

 * Note:

 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 * 
 */
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
 public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode cur = root;
        while(cur != null) {
            TreeLinkNode nextCur = new TreeLinkNode(0);
            TreeLinkNode save = nextCur;
            while(cur != null){
                if(cur.left != null){
                    nextCur.next = cur.left;
                    nextCur = nextCur.next;
                }
                if(cur.right != null) {
                    nextCur.next = cur.right;
                    nextCur = nextCur.next;
                }
                cur = cur.next;
            }
            cur = save.next;
        }
    }
}
 
public PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        Queue<TreeLinkNode> curLevel = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> nextLevel = new LinkedList<TreeLinkNode>();
        curLevel.offer(root);
        while(!curLevel.isEmpty()) {
            TreeLinkNode curNode = curLevel.poll();
            if(!curLevel.isEmpty())
                curNode.next = curLevel.peek();
            else
                curNode.next = null;
            if(curNode.left != null)
                nextLevel.offer(curNode.left);
            if(curNode.right != null)
                nextLevel.offer(curNode.right);
            if(curLevel.isEmpty()) { 
                curLevel = nextLevel;
                nextLevel = new LinkedList<TreeLinkNode>();
            }
        }
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0 ; i < len; i++){
                TreeLinkNode cur = q.poll();
                if(!q.isEmpty() && i != len - 1) {
                    cur.next = q.peek();
                } else {
                    cur.next = null;
                }
                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
    }
}
