class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int l = 0, r = 0, oddCount = 0, count = 0;
        while (r < nums.length) {
            if(nums[r]%2!=0)
            oddCount++;
            while (oddCount > goal) {
                if(nums[l]%2!=0)
                oddCount--;
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}