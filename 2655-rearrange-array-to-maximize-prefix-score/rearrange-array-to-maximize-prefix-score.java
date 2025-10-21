class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        reverse(nums);

        long prefix = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            if (prefix <= 0)
                return i;
        }
        return nums.length;
    }

    private void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
}