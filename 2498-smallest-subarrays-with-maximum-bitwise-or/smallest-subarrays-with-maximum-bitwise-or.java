class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int or = 0;
        int[] last = new int[32];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0)
                    last[j] = i;
            }

            int furthest = i;

            for (int j = 0; j < 32; j++) {
                if (last[j] != 0 || ((nums[i] & (1 << j)) != 0))
                    furthest = Math.max(furthest, last[j]);
            }
            ans[i] = furthest - i + 1;
        }

        return ans;
    }
}