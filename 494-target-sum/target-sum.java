class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();
        int targetSum = (totalSum + target) / 2;

        if (totalSum < Math.abs(target) || (totalSum + target) % 2 != 0)
            return 0;

        int[] dp = new int[targetSum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int s = targetSum; s >= num; s--) {
                dp[s] += dp[s - num];
            }
        }
        return dp[targetSum];
    }
}