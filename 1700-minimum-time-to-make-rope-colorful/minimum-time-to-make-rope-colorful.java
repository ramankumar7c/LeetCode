class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalCost = 0;
        int n = neededTime.length;
        for (int i = 0; i < n - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i + 1)) {
                totalCost += Math.min(neededTime[i], neededTime[i + 1]);
                neededTime[i + 1] = Math.max(neededTime[i], neededTime[i + 1]);
            }
        }
        return totalCost;
    }
}