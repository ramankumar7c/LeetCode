class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            if (pq.size() > k)
                pq.poll();
        }

        int[][] topK = pq.toArray(new int[0][]);
        Arrays.sort(topK, (a, b) -> a[1] - b[1]);

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = topK[i][0];

        return result;
    }
}