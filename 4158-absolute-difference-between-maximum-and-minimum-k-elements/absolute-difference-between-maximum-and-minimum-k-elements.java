class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int minSum = 0, maxSum = 0;
        while (i < k) {
            minSum += nums[i];
            i++;
        }
        int j = nums.length - 1;
        while (j >= nums.length - k) {
            maxSum += nums[j];
            j--;
        }

        return Math.abs(maxSum - minSum);
    }
}