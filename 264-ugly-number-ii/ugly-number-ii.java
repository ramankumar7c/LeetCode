class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0)
            return 0;

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();

        minHeap.add(1L);
        seen.add(1L);

        long currentUgly = 1;

        for (int i = 0; i < n; i++) {
            currentUgly = minHeap.poll();
            if (!seen.contains(currentUgly * 2)) {
                minHeap.add(currentUgly * 2);
                seen.add(currentUgly * 2);
            }
            if (!seen.contains(currentUgly * 3)) {
                minHeap.add(currentUgly * 3);
                seen.add(currentUgly * 3);
            }
            if (!seen.contains(currentUgly * 5)) {
                minHeap.add(currentUgly * 5);
                seen.add(currentUgly * 5);
            }
        }
        return (int) currentUgly;
    }
}