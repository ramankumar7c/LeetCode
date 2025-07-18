class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;

        long[] leftSum = new long[len];
        long[] rightSum = new long[len];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long left = 0;
        for (int i = 0; i < len; i++) {
            maxHeap.offer(nums[i]);
            left += nums[i];
            if (maxHeap.size() > n)
                left -= maxHeap.poll();
            if (maxHeap.size() == n)
                leftSum[i] = left;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long right = 0;
        for (int i = len - 1; i >= 0; i--) {
            minHeap.offer(nums[i]);
            right += nums[i];
            if (minHeap.size() > n)
                right -= minHeap.poll();
            if (minHeap.size() == n)
                rightSum[i] = right;
        }

        long ans = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++)
            ans = Math.min(ans, leftSum[i] - rightSum[i + 1]);

        return ans;
    }
}