class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;

        int left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countPairs(nums, mid) >= p)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    private int countPairs(int[] nums, int maxDiff) {
        int pairs = 0, i = 0;
        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                pairs++;
                i += 2;
            } else
                i++;
        }
        return pairs;
    }
}