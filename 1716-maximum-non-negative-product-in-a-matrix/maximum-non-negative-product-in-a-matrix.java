class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[] maxDp = new long[n];
        long[] minDp = new long[n];

        maxDp[0] = grid[0][0];
        minDp[0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            maxDp[j] = maxDp[j - 1] * grid[0][j];
            minDp[j] = maxDp[j];
        }

        for (int i = 1; i < m; i++) {
            // First column
            maxDp[0] = maxDp[0] * grid[i][0];
            minDp[0] = maxDp[0];

            for (int j = 1; j < n; j++) {
                long val = grid[i][j];

                long topMax = maxDp[j];
                long topMin = minDp[j];
                long leftMax = maxDp[j - 1];
                long leftMin = minDp[j - 1];

                if (val == 0) {
                    maxDp[j] = 0;
                    minDp[j] = 0;
                } else {
                    long a = topMax * val;
                    long b = topMin * val;
                    long c = leftMax * val;
                    long d = leftMin * val;

                    maxDp[j] = Math.max(Math.max(a, b), Math.max(c, d));
                    minDp[j] = Math.min(Math.min(a, b), Math.min(c, d));
                }
            }
        }

        long result = maxDp[n - 1];
        if (result < 0)
            return -1;

        return (int) (result % 1_000_000_007);
    }
}