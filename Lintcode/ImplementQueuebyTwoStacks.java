public class Solution {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Solution() {
       // do initialization if necessary
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        while(stack1.size() != 1){
            stack2.push(stack1.pop());
        }
        int val = stack1.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return val;
    }

    public int top() {
        // write your code here
        while(stack1.size() != 1){
            stack2.push(stack1.pop());
        }
        int val = stack1.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return val;
    }
}

