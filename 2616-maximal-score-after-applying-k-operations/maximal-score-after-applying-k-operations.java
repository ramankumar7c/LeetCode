class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums)
            maxHeap.offer(num);

        for (int i = 0; i < k; i++) {
            int num = maxHeap.poll();
            ans += num;
            maxHeap.offer((num + 2) / 3);
        }
        return ans;
    }
}