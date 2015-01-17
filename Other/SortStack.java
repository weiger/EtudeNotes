import java.util.Stack;

public class Solution {
    public void sortStack(Stack<Integer> stack) {
    	if(!stack.isEmpty()){
    	    int tmp = stack.pop();
    	    sortStack(stack);
    	    insert(stack,tmp);
    	}
    }
    public void insert(Stack<Integer> stack, int num) {
	if(stack.isEmpty()){
    	    stack.push(num);
    	}else{
    	    int a = stack.peek();
    	    if(num < a){
        		stack.pop();
        		insert(stack,num);
        		stack.push(a);
    	    }else{
    		    stack.push(num);
    	    }
    	}
    }

    public static void main(String[] args) {
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i < 9; i++) {
    	    stack.push((int) (10 * Math.random()));
    	}
    	new Solution().sortStack(stack);
    	while (!stack.isEmpty())
    	    System.out.print(stack.pop() + " ");
    }
}
