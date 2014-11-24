/*
from
     4
   /   \
  2     5
 / \     \
1   3     6
to
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
*/


public class Solution{
    static TreeNode temp = null;
    static TreeNode newroot = null;
    public void flatten(TreeNode p) {
	if (p == null)
	    return;
	flatten(p.left);
	if (temp != null) {
	    temp.right = p;
	    p.left = null;
	}
	if(temp ==null){
	    newroot = p;
	    temp = p;
	}
	else{
	    temp = p;
	}
	flatten(p.right);
    }
}
