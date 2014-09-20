/*
Print All external Nodes
        8
      /   \
    4      11
     \    /  \
      6  9    12
       \
        7
Output: 4 6 7 9 11 12 (No requirement on Sequence)
public class Solution{
  public void printExt(Node root){
		if(root==null) return;
		left_dfs(root.llink,true);
		right_dfs(root.rlink,true);
	}
	
	private void right_dfs(Node p, boolean is_ext)
	{
		if(p==null) return;
		if(is_ext||(p.llink==null && p.rlink==null))
			System.out.print(p.data+" ");
		right_dfs(p.llink,is_ext&&(p.rlink==null));
		right_dfs(p.rlink,is_ext);
		
		
	}

	private void left_dfs(Node p, boolean is_ext)
	{
		if(p==null) return;
		if(is_ext||(p.llink==null && p.rlink==null))
			System.out.print(p.data+" ");
		left_dfs(p.llink,is_ext);
		left_dfs(p.rlink,is_ext&&(p.llink==null));
	}

}
