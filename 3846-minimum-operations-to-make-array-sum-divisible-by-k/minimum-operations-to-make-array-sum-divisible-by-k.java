class Solution {
    public int minOperations(int[] nums, int k) {
        int mod = 0;
        for (int x : nums)
            mod = (mod + x) % k;

        return mod;
    }
}