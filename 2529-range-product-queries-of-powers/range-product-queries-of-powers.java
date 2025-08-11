class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = 1_000_000_007;
        int MAX_BIT = 30;
        List<Long> pows = new ArrayList<>();

        for (int i = 0; i < MAX_BIT; i++)
            if ((n >> i & 1) == 1)
                pows.add(1L << i);

        int m = pows.size();
        long[] prefix = new long[m + 1];
        prefix[0] = 1;
        for (int i = 0; i < m; i++)
            prefix[i + 1] = (prefix[i] * pows.get(i)) % MOD;

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long numerator = prefix[r + 1];
            long denominator = prefix[l];
            ans[i] = (int) ((numerator * modInverse(denominator, MOD)) % MOD);
        }
        return ans;
    }

    private long modInverse(long x, int mod) {
        return modPow(x, mod - 2, mod);
    }

    private long modPow(long base, long exp, int mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}