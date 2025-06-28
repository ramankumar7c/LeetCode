class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] { nums[i], i });
            if (pq.size() > k)
                pq.poll();
        }

        int[][] topK = pq.toArray(new int[0][]);
        Arrays.sort(topK, Comparator.comparingInt(a -> a[1]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = topK[i][0];

        return result;
    }
}