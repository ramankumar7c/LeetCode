class Solution {
    public int countHillValley(int[] nums) {
        int ans = 0;
        int start = nums[0];

        for (int i = 1; i + 1 < nums.length; i++) {
            if (start < nums[i] && nums[i] > nums[i + 1] || start > nums[i] && nums[i] < nums[i + 1]) {
                ans++;
                start = nums[i];
            }
        }
        return ans;
    }
}