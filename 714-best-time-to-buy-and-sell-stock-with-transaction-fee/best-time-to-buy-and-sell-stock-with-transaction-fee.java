class Solution {
    public int maxProfit(int[] prices, int fee) {
        int sell = 0;
        int hold = -prices[0] - fee;

        for (int i = 1; i < prices.length; i++) {
            int tempSell = Math.max(sell, hold + prices[i]);
            int tempHold = Math.max(hold, sell - prices[i] - fee);
            sell = tempSell;
            hold = tempHold;
        }
        return sell;
    }
}