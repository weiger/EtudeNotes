public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public interface PreOrderBinaryTreeIterator extends Iterator<Integer> { 
  /** Returns the next integer a in the pre-order traversal of the given binary tree.
   * For example, given a binary tree below,
   *       4
   *      / \
   *     2   6
   *    / \ / \
   *   1  3 5  7
   * the outputs will be 4, 2, 1, 3, 6, 5, 7. 
   */ 
  public Integer next(); 

  /** Return true if traversal has not finished; otherwise, return false.
   */ 
  public boolean hasNext();
}

public class PreOrderBinaryTreeIterator implements PreOrderBinaryTreeIterator {
	private Stack<TreeNode> cache;

	public PreOrderBinaryTreeIterator(TreeNode root) {
		cache = new Stack<TreeNode>();
		if (root != null) {
			cache.push(root);
		}
	}

	public boolean hasNext() {
		return !cache.isEmpty();
	}

	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException("all nodes have been visited!");
		}
		TreeNode res = cache.pop();
		if (res.right != null) {
			cache.push(res.right);
		}
		if (res.left != null) {
			cache.push(res.left);
		}
		return res.val;
	}
}

//inorder iterator
public class InOrderBinaryTreeIterator implements InOrderBinaryTreeIterator {
	private Stack<TreeNode> cache;

	public InOrderBinaryTreeIterator(TreeNode root) {
		cache = new Stack<TreeNode>();
		while (root != null) {
			addElement(root);
		}
	}

	public void addElement(TreeNode curr) {
		TreeNode prev = curr;
		while (prev != null) {
			cache.push(prev);
			prev = prev.left;
		}
	}

	public boolean hasNext() {
		return !cache.isEmpty();
	}

	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException("all nodes have been visited!");
		}
		TreeNode res = cache.pop();
		if (res.right != null) {
			addElement(res.right);
		}
		return res.val;
	}
}

//postorder iterator
public class PostOrderBinaryTreeIterator implements PostOrderBinaryTreeIterator {
	private Stack<TreeNode> cache;
	public InOrderBinaryTreeIterator(TreeNode root) {
		if (root != null) {
			storeElement(root);
		}
	}

    public void storeElement(TreeNode curr) {
    	while (curr != null) {
    		cache.push(curr);
    		if (curr.left != null) {
    			curr = curr.left;
    		} else {
    			curr = curr.right;
    		}
    	}
    }

    public boolean hasNext() {
    	return !cache.isEmpty();
    }

    public Integer next() {
    	if (!hasNext()) {  
           throw new NoSuchElementException("All nodes have been visited!");  
        } 
    	TreeNode curr = cache.pop();
    	if (!cache.isEmpty()) {
    		TreeNode pk = cache.peek();
    		if (pk.left == curr) {
    			storeElement(pk.right);
    		}
    	}
    	return curr.val;
    }
}
