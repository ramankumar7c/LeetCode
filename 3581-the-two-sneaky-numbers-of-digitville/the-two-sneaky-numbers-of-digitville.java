class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        int n = nums.length;
        int[] freq = new int[n];

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (++freq[nums[i]] == 2)
                ans[j++] = nums[i];
        }
        return ans;
    }
}