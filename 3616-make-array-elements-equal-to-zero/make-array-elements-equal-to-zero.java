class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (simulate(nums, i, 1))
                    count++;
                if (simulate(nums, i, -1))
                    count++;
            }
        }
        return count;
    }

    private boolean simulate(int[] nums, int start, int dir) {
        int n = nums.length;
        int curr = start;
        int[] arr = nums.clone();

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0)
                curr += dir;
            else {
                arr[curr]--;
                dir = -dir;
                curr += dir;
            }
        }
        for (int val : arr)
            if (val != 0)
                return false;

        return true;
    }
}