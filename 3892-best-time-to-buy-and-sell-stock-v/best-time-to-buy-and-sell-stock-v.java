class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        if (n == 0 || k == 0)
            return 0L;

        long NEG = Long.MIN_VALUE / 4;

        long[] free = new long[k + 1];
        long[] longPos = new long[k + 1];
        long[] shortPos = new long[k + 1];

        for (int t = 0; t <= k; t++) {
            free[t] = NEG;
            longPos[t] = NEG;
            shortPos[t] = NEG;
        }
        free[0] = 0;

        for (int price : prices) {
            for (int t = k; t >= 1; t--) {
                free[t] = Math.max(free[t], Math.max(longPos[t] + price, shortPos[t] - price));

                longPos[t] = Math.max(longPos[t], free[t - 1] - price);
                shortPos[t] = Math.max(shortPos[t], free[t - 1] + price);
            }
        }

        long ans = 0;
        for (int t = 0; t <= k; t++)
            ans = Math.max(ans, free[t]);

        return ans;
    }
}