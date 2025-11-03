class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int i = 0, j = 1;
        while (i < n) {
            while (i < n && nums[i] % 2 == 0)
                i += 2;
            while (j < n && nums[j] % 2 == 1)
                j += 2;
            if (i < n) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i += 2;
                j += 2;
            }
        }
        return nums;
    }
}