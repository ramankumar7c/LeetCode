class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return changeUtil(coins, n - 1, amount, dp);
    }

    private int changeUtil(int[] coins, int index, int amount, int[][] dp) {
        if (index == 0) {
            if (amount % coins[index] == 0)
                return 1;
            else
                return 0;
        }

        if (dp[index][amount] != -1)
            return dp[index][amount];

        int notTaken = changeUtil(coins, index - 1, amount, dp);

        int taken = 0;
        if (coins[index] <= amount)
            taken = changeUtil(coins, index, amount - coins[index], dp);

        return dp[index][amount] = taken + notTaken;
    }
}