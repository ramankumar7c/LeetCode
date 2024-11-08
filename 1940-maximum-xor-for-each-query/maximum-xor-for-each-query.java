class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int mx = (1 << maximumBit) - 1;
        int[] ans = new int[n];

        int xors = 0;
        for (int num : nums)
            xors ^= num;

        for (int i = 0; i < n; i++) {
            ans[i] = xors ^ mx;
            xors ^= nums[n - 1 - i];
        }
        return ans;
    }
}