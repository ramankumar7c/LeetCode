class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = bS(nums, target, true);
        int last = bS(nums, target, false);
        return new int[] { first, last };
    }

    private int bS(int[] nums, int target, boolean findFirst) {
        int index = -1;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] < target)
                l = mid + 1;
            else if (nums[mid] > target)
                h = mid - 1;
            else {
                index = mid;
                if (findFirst)
                    h = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return index;
    }
}