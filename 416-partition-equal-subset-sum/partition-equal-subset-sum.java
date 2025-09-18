class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;

        int subsetSum = sum / 2;
        boolean[] dp = new boolean[subsetSum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = subsetSum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
                if (dp[subsetSum])
                    return true;
            }
        }
        return dp[subsetSum];
    }
}