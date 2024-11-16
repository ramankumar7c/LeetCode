class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int count = 1;

        if (k == 1) {
            for (int i = 0; i < n; i++)
                ans[i] = nums[i];
            return ans;
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1)
                count++;
            else
                count = 1;

            if (i >= k - 1) {
                if (count >= k)
                    ans[i - k + 1] = nums[i];
                else
                    ans[i - k + 1] = -1;
            }
        }

        return ans;
    }
}