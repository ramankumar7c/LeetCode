class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = (int) 1e9 + 7;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                minHeap.add(sum);
            }
        }
        long ans = 0;
        for (int i = 1; i <= right; i++) {
            if (i >= left)
                ans = (ans + minHeap.poll()) % MOD;
            else
                minHeap.poll();
        }
        return (int) ans;
    }
}