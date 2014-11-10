class MinStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty()||x<=stack2.peek())
            stack2.push(x);
    }

    public void pop() {
        int val;
        if(!stack1.isEmpty()){
            val = stack1.pop();
            if(val==stack2.peek())
                stack2.pop();
        }
    }

    public int top() {
        if(!stack1.isEmpty())
            return stack1.peek();
        else
            return -1;
    }

    public int getMin() {
        if(!stack2.isEmpty())
            return stack2.peek();
        else
            return -1;
    }
}
