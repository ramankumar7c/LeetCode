class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int k = (int) Arrays.stream(nums).filter(a -> a == 1).count();

        if (k == 0 || k == n)
            return 0;

        int currentOnes = 0;
        for (int i = 0; i < k; i++)
            if (nums[i] == 1)
                currentOnes++;

        int maxOnes = currentOnes;

        for (int i = k; i < n + k; i++) {
            if (nums[i % n] == 1)
                currentOnes++;
            if (nums[(i - k) % n] == 1)
                currentOnes--;
            maxOnes = Math.max(maxOnes, currentOnes);
        }
        return k - maxOnes;
    }
}