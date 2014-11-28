/*
mplement a stack with min() function, which will return the smallest number in the stack.

It should support push, pop and min operation all in O(1) cost.

Note
min operation will never be called if there is no number in the stack

Example
Operations: push(1), pop(), push(2), push(3), min(), push(1), min() Return: 1, 2, 1
*/

public class Solution {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public Solution() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int number) {
        stack1.push(number);
        if(stack2.isEmpty() || number<=stack2.peek())
            stack2.push(number);
    }

    public int pop() {
        int v = stack1.pop();
        if(v==stack2.peek())
            stack2.pop();
        return v;
    }

    public int min() {
        return stack2.peek();
    }
}

