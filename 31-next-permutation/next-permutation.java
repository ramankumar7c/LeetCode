class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        for (int i = n - 2; i >= 0; i--)
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }

        if (pivot != -1) {
            int successor = n - 1;
            while (nums[successor] <= nums[pivot])
                successor--;

            swap(nums, pivot, successor);
        }
        reverse(nums, pivot + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}