class Solution {
    public int checkRecord(int n) {
        final int kMod = 1_000_000_007;

        int[][][] dp = new int[n + 1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % kMod;

                    if (k < 2)
                        dp[i][j][k + 1] = (dp[i][j][k + 1] + dp[i - 1][j][k]) % kMod;

                    if (j < 1)
                        dp[i][j + 1][0] = (dp[i][j + 1][0] + dp[i - 1][j][k]) % kMod;
                }
            }
        }
        int result = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++)
                result = (result + dp[n][j][k]) % kMod;
        }
        return result;
    }
}