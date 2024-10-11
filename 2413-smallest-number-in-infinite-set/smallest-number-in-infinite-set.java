class SmallestInfiniteSet {
    private int curr;
    private PriorityQueue<Integer> pq;
    private boolean[] added;

    public SmallestInfiniteSet() {
        curr = 1;
        pq = new PriorityQueue<>();
        added = new boolean[1001];
    }

    public int popSmallest() {
        if (!pq.isEmpty()) {
            int smallest = pq.poll();
            added[smallest] = false;
            return smallest;
        }
        return curr++;
    }

    public void addBack(int num) {
        if (num < curr && !added[num]) {
            pq.offer(num);
            added[num] = true;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */