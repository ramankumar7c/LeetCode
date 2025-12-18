class Solution {
    public long[] sumOfThree(long num) {
        long n = num / 3;
        if (n * 3 != num)
            return new long[] {};

        long[] ans = new long[3];

        ans[0] = n - 1;
        ans[1] = n;
        ans[2] = n + 1;

        return ans;
    }
}