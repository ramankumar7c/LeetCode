class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            int diff = Math.abs(nums[i] - nums[i + 1]);
            maxDiff = Math.max(maxDiff, diff);
        }
        maxDiff = Math.max(maxDiff, Math.abs(nums[0] - nums[n - 1]));

        return maxDiff;
    }
}