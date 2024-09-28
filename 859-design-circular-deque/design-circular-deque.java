class MyCircularDeque {

    private int[] q;
    private int k;
    private int size;
    private int front;

    public MyCircularDeque(int k) {
        this.k = k;
        this.q = new int[k];
        this.front = 0;
        this.size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;

        front = (front - 1 + k) % k;
        q[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;

        int rear = (front + size) % k;
        q[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;

        front = (front + 1) % k;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;

        int rear = (front + size - 1 + k) % k;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : q[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : q[(front + size - 1) % k];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */