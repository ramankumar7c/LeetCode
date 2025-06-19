class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int cnt = 1, min = nums[0];
        for (int i = 0; i < n; i++) {
            if (min + k < nums[i]) {
                cnt++;
                min = nums[i];
            }
        }
        return cnt;
    }
}