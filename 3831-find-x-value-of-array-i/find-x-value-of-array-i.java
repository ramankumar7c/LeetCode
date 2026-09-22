class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            num %= k;

            long[] next = new long[k];
            next[num]++;

            for (int r = 0; r < k; r++) {
                next[(r * num) % k] += dp[r];
            }

            dp = next;

            for (int r = 0; r < k; r++) {
                ans[r] += dp[r];
            }
        }

        return ans;
    }
}