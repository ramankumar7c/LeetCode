class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;

        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {
                flip(nums, i, i + 2);
                operations++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                return -1;
        }
        return operations;
    }

    private static void flip(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            nums[i] = 1 - nums[i];
        }
    }
}