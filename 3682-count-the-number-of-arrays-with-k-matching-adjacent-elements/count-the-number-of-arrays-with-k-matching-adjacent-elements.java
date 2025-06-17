class Solution {
    private static int MOD = 1_000_000_007;

    public int countGoodArrays(int n, int m, int k) {
        if (k > n - 1)
            return 0;

        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        computeFactAndInvFact(n, fact, invFact);

        long ways = m * modPow(m - 1, n - 1 - k) % MOD;
        ways = ways * comb(n - 1, k, fact, invFact) % MOD;
        return (int) ways;
    }

    private void computeFactAndInvFact(int n, long[] fact, long[] invFact) {
        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = fact[i - 1] * i % MOD;

        invFact[n] = modInverse(fact[n], MOD);
        for (int i = n - 1; i >= 0; i--)
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;

    }

    private long comb(int n, int k, long[] fact, long[] invFact) {
        if (k < 0 || k > n)
            return 0;

        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    private long modInverse(long a, int mod) {
        return modPow(a, mod - 2);
    }

    private long modPow(long a, long b) {
        long res = 1;
        a = a % MOD;
        while (b > 0) {
            if (b % 2 == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b /= 2;
        }
        return res;
    }
}