/*
Fair Implement Queue by Stacks Show Result My Submissions

36% Accepted
As the title described, you should only use two stacks to implement a queue's actions.

The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.

Both pop and top methods should return the value of first element.

Example
For push(1), pop(), push(2), push(3), top(), pop(), you should return 1, 2 and 2
*/

public class Solution {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Solution() {
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int top() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
}
