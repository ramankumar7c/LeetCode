class Solution {
    public int countSquares(int[][] matrix) {
        int[] dp = new int[matrix[0].length];
        int count = 0, prev = 0;
        for (int i = 0; i < matrix.length; i++) {
            prev = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = dp[j];
                if (matrix[i][j] == 1) {
                    if (j == 0)
                        dp[j] = 1;
                    else
                        dp[j] = Math.min(Math.min(dp[j], dp[j - 1]), prev) + 1;
                    count += dp[j];
                } else
                    dp[j] = 0;
                prev = temp;
            }
        }
        return count;
    }
}