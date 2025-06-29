class Solution {
    public int numSubseq(int[] nums, int target) {
        final int MOD = 1_000_000_007;
        int n = nums.length;
        Arrays.sort(nums);

        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; ++i)
            pow[i] = (pow[i - 1] * 2) % MOD;

        int left = 0, right = n - 1;
        int ans = 0;
        
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                ans = (ans + pow[right - left]) % MOD;
                left++;
            }
            else
                right--;
        }
        
        return ans;
    }
}