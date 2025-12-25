class Solution {
    public int minimumCost(int[] cost) {
        int minCost = 0;
        Arrays.sort(cost);

        int i = cost.length - 1;
        while (i >= 0) {
            minCost += cost[i--];
            if (i >= 0)
                minCost += cost[i--];
            i--;
        }
        return minCost;
    }
}