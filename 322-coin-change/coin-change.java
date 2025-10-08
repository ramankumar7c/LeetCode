class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2);

        int result = dfs(coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(int[] coins, int rem, int[] dp) {

        if (rem == 0)
            return 0;
        if (rem < 0)
            return Integer.MAX_VALUE;

        if (dp[rem] != -2)
            return dp[rem];

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, rem - coin, dp);
            if (res != Integer.MAX_VALUE)
                minCoins = Math.min(minCoins, 1 + res);
        }

        dp[rem] = minCoins;
        return minCoins;
    }
}