class Solution {
    public long maxPoints(int[][] points) {
        int n = points[0].length;
        long[] dp = new long[n];

        for (int[] row : points) {
            long[] newDp = new long[n];

            long runningMax = dp[0];
            newDp[0] = runningMax;
            for (int j = 1; j < n; j++) {
                runningMax = Math.max(runningMax - 1, dp[j]);
                newDp[j] = runningMax;
            }
            runningMax = dp[n - 1];
            newDp[n - 1] = Math.max(newDp[n - 1], runningMax);
            for (int j = n - 2; j >= 0; j--) {
                runningMax = Math.max(runningMax - 1, dp[j]);
                newDp[j] = Math.max(newDp[j], runningMax);
            }
            for (int j = 0; j < n; j++)
                newDp[j] += row[j];

            dp = newDp;
        }
        return Arrays.stream(dp).max().getAsLong();
    }
}