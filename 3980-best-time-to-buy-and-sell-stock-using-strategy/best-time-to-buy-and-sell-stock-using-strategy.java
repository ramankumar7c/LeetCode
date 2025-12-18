class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long baseProfit = 0;
        for (int i = 0; i < n; i++)
            baseProfit += (long) strategy[i] * prices[i];

        long[] loss = new long[n];
        long[] gain = new long[n];

        for (int i = 0; i < n; i++) {
            loss[i] = -(long) strategy[i] * prices[i];
            gain[i] = (long) (1 - strategy[i]) * prices[i];
        }

        long[] prefLoss = new long[n + 1];
        long[] prefGain = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefLoss[i + 1] = prefLoss[i] + loss[i];
            prefGain[i + 1] = prefGain[i] + gain[i];
        }

        long bestGain = 0;
        int half = k / 2;

        for (int l = 0; l + k <= n; l++) {
            int mid = l + half;
            int r = l + k;

            long curGain = (prefLoss[mid] - prefLoss[l]) + (prefGain[r] - prefGain[mid]);

            bestGain = Math.max(bestGain, curGain);
        }

        return baseProfit + bestGain;
    }
}