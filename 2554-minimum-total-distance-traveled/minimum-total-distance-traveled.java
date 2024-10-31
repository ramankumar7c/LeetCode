class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int n = robot.size();
        int m = factory.length;

        long[][] dp = new long[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], Long.MAX_VALUE / 2);

        dp[0][0] = 0;

        for (int j = 1; j <= m; j++) {
            int factoryPos = factory[j - 1][0];
            int factoryLimit = factory[j - 1][1];

            for (int i = 0; i <= n; i++) {
                dp[j][i] = Math.min(dp[j][i], dp[j - 1][i]);

                long distanceSum = 0;
                for (int k = 1; k <= factoryLimit && i - k >= 0; k++) {
                    distanceSum += Math.abs(robot.get(i - k) - factoryPos);
                    dp[j][i] = Math.min(dp[j][i], dp[j - 1][i - k] + distanceSum);
                }
            }
        }
        return dp[m][n];
    }
}