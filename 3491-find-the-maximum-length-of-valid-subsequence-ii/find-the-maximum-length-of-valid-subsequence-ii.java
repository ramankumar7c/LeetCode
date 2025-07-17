class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];

        for (int num : nums) {
            int currMod = num % k;
            for (int prevMod = 0; prevMod < k; prevMod++) {
                if (dp[prevMod][currMod] < dp[currMod][prevMod] + 1)
                    dp[prevMod][currMod] = dp[currMod][prevMod] + 1;
            }
        }

        int maxLength = 0;
        for (int[] row : dp)
            for (int val : row)
                maxLength = Math.max(maxLength, val);

        return maxLength;
    }
}