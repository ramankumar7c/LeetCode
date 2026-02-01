class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int minSoFar = nums[1];

        for (int j = 2; j < n; j++) {
            ans = Math.min(ans, nums[0] + minSoFar + nums[j]);
            minSoFar = Math.min(minSoFar, nums[j]);
        }
        return ans;
    }
}