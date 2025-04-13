class Solution {
    private static int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;
        long evenChoices = modPow(5, evenPositions);
        long oddChoices = modPow(4, oddPositions);

        return (int) ((evenChoices * oddChoices) % MOD);
    }

    private long modPow(long x, long n) {
        long result = 1;
        x = x % MOD;
        while (n > 0) {
            if (n % 2 == 1)
                result = (result * x) % MOD;
            x = (x * x) % MOD;
            n = n / 2;
        }
        return result;
    }
}