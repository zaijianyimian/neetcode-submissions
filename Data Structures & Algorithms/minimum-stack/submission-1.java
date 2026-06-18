class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(val);
            minStack.push(val);
        }else{
            if(val <= minStack.peek()){
                minStack.push(val);
            }
            stack.push(val);
        }
    }
    
    public void pop() {
        if(stack.pop().equals(minStack.peek())){
            minStack.pop();
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
        
    }
}
