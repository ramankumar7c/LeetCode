class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int l = 0;
        int maxLen = 1;

        for (int r = 0; r < n; r++) {
            while ((long) nums[r] > (long) k * nums[l]) {
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return n - maxLen;
    }
}