class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long maxSum = 0;
        int changeCount = 0;
        int minChangeDiff = Integer.MAX_VALUE;
        for (int num : nums) {
            int changedValue = num ^ k;
            maxSum += Math.max(num, changedValue);
            changeCount += (changedValue > num) ? 1 : 0;
            minChangeDiff = Math.min(minChangeDiff, Math.abs(num - changedValue));
        }
        if (changeCount % 2 == 0)
            return maxSum;
        return maxSum - minChangeDiff;
    }
}