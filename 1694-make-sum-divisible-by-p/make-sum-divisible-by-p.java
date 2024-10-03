class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;

        for (int num : nums)
            sum += num;

        int remainder = (int) (sum % p);
        if (remainder == 0)
            return 0;

        int minLen = n;
        int prefix = 0;
        Map<Integer, Integer> prefixToIndex = new HashMap<>();
        prefixToIndex.put(0, -1);

        for (int i = 0; i < n; i++) {
            prefix = (prefix + nums[i]) % p;

            int target = (prefix - remainder + p) % p;

            if (prefixToIndex.containsKey(target))
                minLen = Math.min(minLen, i - prefixToIndex.get(target));

            prefixToIndex.put(prefix, i);
        }
        return minLen == n ? -1 : minLen;
    }
}