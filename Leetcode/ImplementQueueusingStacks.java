class MyQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (s1.size() != 1) {
            s2.push(s1.pop());
        }
        s1.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Get the front element.
    public int peek() {
        while (s1.size() != 1) {
            s2.push(s1.pop());
        }
        int val = s1.peek();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return val;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }
}
