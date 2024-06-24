class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int[] isFlipped = new int[n + 1];

        int flip = 0;

        for (int i = 0; i < n; i++) {
            flip ^= isFlipped[i];

            if (nums[i] == flip) {
                if (i + k > n) {
                    return -1;
                }
                ans++;
                flip ^= 1;
                isFlipped[i + k] ^= 1;
            }
        }
        return ans;
    }
}