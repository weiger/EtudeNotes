class MinStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty()||x<=stack2.peek())
            stack2.push(x);
    }
    //return type of peek() is reference
    public void pop() {
        if(!stack1.isEmpty()){
            if((int)stack1.peek()==(int)stack2.peek()){
                stack2.pop();
            }
            stack1.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
