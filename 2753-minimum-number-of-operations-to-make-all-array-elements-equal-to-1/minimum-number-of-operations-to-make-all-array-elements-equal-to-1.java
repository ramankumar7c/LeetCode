class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int ones = (int) Arrays.stream(nums).filter(num -> num == 1).count();

        if (ones > 0)
            return n - ones;

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int curG = nums[i];
            for (int j = i + 1; j < n; j++) {
                curG = gcd(curG, nums[j]);
                if (curG == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        if (minLen == Integer.MAX_VALUE)
            return -1;
        else
            return (minLen - 1) + (n - 1);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}