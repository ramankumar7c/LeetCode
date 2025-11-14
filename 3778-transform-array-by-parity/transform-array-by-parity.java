class Solution {
    public int[] transformArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int evenCount = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                evenCount++;
            }
        }

        int i = 0;
        while (i < evenCount) {
            ans[i++] = 0;
        }
        while (i < n) {
            ans[i++] = 1;
        }

        return ans;
    }
}