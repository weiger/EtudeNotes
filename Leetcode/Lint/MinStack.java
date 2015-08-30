public class Solution {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public Solution() {
        // do initialize if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack1.push(number);
        if(stack2.isEmpty() || number <= stack2.peek()){
            stack2.push(number);
        }
    }

    public int pop() {
        // write your code here
        if(!stack1.isEmpty()){
            int val = stack1.pop();
            if(!stack2.isEmpty() && val == stack2.peek()){
                stack2.pop();
            }
            return val;
        }else{
            return -1;
        }
    }

    public int min() {
        // write your code here
        if(!stack2.isEmpty()){
            return stack2.peek();
        }else{
            return -1;
        }
    }
}

