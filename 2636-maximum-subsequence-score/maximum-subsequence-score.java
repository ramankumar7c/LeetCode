class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long ans = 0;
        long sum = 0;
        int n = nums1.length;

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++)
            indices[i] = i;

        Arrays.sort(indices, (a, b) -> Integer.compare(nums2[b], nums2[a]));
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            sum += nums1[idx];
            minHeap.offer(nums1[idx]);

            if (minHeap.size() > k)
                sum -= minHeap.poll();

            if (minHeap.size() == k)
                ans = Math.max(ans, sum * nums2[idx]);
        }
        return ans;
    }
}