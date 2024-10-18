class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOr = 0;

        for (int num : nums)
            maxOr |= num;

        int subsetCount = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            int currentOr = 0;

            for (int i = 0; i < n; i++)
                if ((mask & (1 << i)) != 0)
                    currentOr |= nums[i];
            
            if (currentOr == maxOr)
                subsetCount++;
        }
        return subsetCount;
    }
}