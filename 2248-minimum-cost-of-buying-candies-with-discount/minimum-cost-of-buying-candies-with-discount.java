class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int minCost = 0;
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