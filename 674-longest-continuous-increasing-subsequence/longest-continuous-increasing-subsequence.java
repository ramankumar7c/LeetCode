class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (r > 0 && nums[r] <= nums[r - 1])
                l = r;
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}