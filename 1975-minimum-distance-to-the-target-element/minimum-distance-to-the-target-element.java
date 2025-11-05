class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == target)
                min = Math.min(min, Math.abs(i - start));
        }
        return min;
    }
}