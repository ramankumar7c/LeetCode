class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long MOD = 1_000_000_007;

        Map<Integer, Integer> right = new HashMap<>();
        for (int x : nums)
            right.put(x, right.getOrDefault(x, 0) + 1);

        Map<Integer, Integer> left = new HashMap<>();

        long ans = 0;

        for (int j = 0; j < n; j++) {
            int val = nums[j];
            right.put(val, right.get(val) - 1);
            if (right.get(val) == 0)
                right.remove(val);

            int need = val * 2;

            int leftCount = left.getOrDefault(need, 0);
            int rightCount = right.getOrDefault(need, 0);

            ans = (ans + (long) leftCount * rightCount) % MOD;

            left.put(val, left.getOrDefault(val, 0) + 1);
        }

        return (int) ans;
    }
}