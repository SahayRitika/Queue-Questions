class MyStack {
    Deque<Integer> deque;
    public MyStack() {
        deque= new LinkedList();
    }
    
    public void push(int x) {
        deque.addLast(x);
        return;
    }
    
    public int pop() {
        return deque.removeLast();
       
    }
    
    public int top() {
        return deque.getLast();
    }
    
    public boolean empty() {
        return deque.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
