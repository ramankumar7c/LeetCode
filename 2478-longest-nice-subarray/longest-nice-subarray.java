class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = 0;
        int left = 0;
        int currentMask = 0;

        for (int right = 0; right < nums.length; right++) {
            while ((currentMask & nums[right]) != 0) {
                currentMask ^= nums[left];
                left++;
            }

            currentMask |= nums[right];

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}