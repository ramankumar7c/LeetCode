class CustomStack {
    private int maxSize;
    private int[] stack;
    private int[] increment;
    private int top;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.increment = new int[maxSize];
        this.top = 0;
    }

    public void push(int x) {
        if (top == maxSize)
            return;
        stack[top] = x;
        top++;
    }

    public int pop() {
        if (top == 0)
            return -1;
        top--;
        int res = stack[top] + increment[top];
        if (top > 0)
            increment[top - 1] += increment[top];
        increment[top] = 0;
        return res;
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, top);
        if (limit > 0)
            increment[limit - 1] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */