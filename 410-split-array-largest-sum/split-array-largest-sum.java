class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canSplit(nums, k, mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1, currentSum = 0;
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;
                if (count > k)
                    return false;
            } else
                currentSum += num;
        }
        return true;
    }
}