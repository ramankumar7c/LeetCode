class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long mod = 1_000_000_007L;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];

        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> minD = new ArrayDeque<>();
        Deque<Integer> maxD = new ArrayDeque<>();

        int left = 0;

        for (int right = 1; right <= n; right++) {
            int val = nums[right - 1];

            while (!minD.isEmpty() && nums[minD.peekLast()] > val)
                minD.pollLast();
            minD.offerLast(right - 1);

            while (!maxD.isEmpty() && nums[maxD.peekLast()] < val)
                maxD.pollLast();
            maxD.offerLast(right - 1);

            while (nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {
                if (minD.peekFirst() == left)
                    minD.pollFirst();
                if (maxD.peekFirst() == left)
                    maxD.pollFirst();
                left++;
            }

            if (left == 0)
                dp[right] = prefix[right - 1];
            else
                dp[right] = (prefix[right - 1] - prefix[left - 1] + mod) % mod;

            prefix[right] = (prefix[right - 1] + dp[right]) % mod;
        }

        return (int) dp[n];
    }
}