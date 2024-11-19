class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long sum = 0;
        int distinct = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            if (count.get(nums[i]) == 1)
                distinct++;

            if (i >= k) {
                count.put(nums[i - k], count.get(nums[i - k]) - 1);
                if (count.get(nums[i - k]) == 0)
                    distinct--;
                sum -= nums[i - k];
            }

            if (i >= k - 1 && distinct == k)
                ans = Math.max(ans, sum);
        }
        return ans;
    }
}