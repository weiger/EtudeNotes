/*
* Follow up for problem "Populating Next Right Pointers in Each Node".

* Note:

* You may only use constant extra space.
* For example,
* Given the following binary tree,
*     1
*    / \
*   2   3
*  / \   \
* 4   5   7
* After calling your function, the tree should look like:
*       1 
*      / 
*     2   
*   /  \
*  4    3
*   \
*    5
*     \
*      7
/**
* Definition for binary tree with next pointer.
* public class TreeLinkNode {
* int val;
* TreeLinkNode left, right, next;
* TreeLinkNode(int x) { val = x; }
* }
*/

public void flattedn(TreeLinkNode p) //BFS
	{
		if (p == null)
			return;
		Queue<TreeLinkNode> cur = new LinkedList<TreeLinkNode>();
		Queue<TreeLinkNode> next = new LinkedList<TreeLinkNode>();
		boolean mostleft = true; //flag of left most
		TreeLinkNode temp = null; 
		cur.offer(p);
		while (!cur.isEmpty())
		{		
			Node pt = cur.poll();
			if (pt.left != null)
				next.offer(pt.left);
			if (pt.right!= null)
				next.offer(pt.right);
			if(mostleft){
				mostleft = false;
			}	
			else{
				pt.left = null;			
			}
			//connect every node in same level
			if(temp!=null){
				temp.right = pt;
			}
			temp = pt;
	
			if (cur.isEmpty())
			{
				pt.right=null;  //be careful of last node
				temp = null;    //dont forget this node
				cur = next;
				next = new LinkedList<TreeLinkNode>();
				mostleft = true;
			}
		}
	}
