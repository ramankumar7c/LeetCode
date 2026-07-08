class Solution {
    static final long MOD = 1000000007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] valPrefix = new long[n + 1];
        int[] cntPrefix = new int[n + 1];
        long[] sumPrefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            valPrefix[i + 1] = valPrefix[i];
            cntPrefix[i + 1] = cntPrefix[i];
            sumPrefix[i + 1] = sumPrefix[i];

            if (d != 0) {
                valPrefix[i + 1] = (valPrefix[i] * 10 + d) % MOD;
                cntPrefix[i + 1]++;
                sumPrefix[i + 1] += d;
            }
        }

        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int digits = cntPrefix[r + 1] - cntPrefix[l];

            long x = (valPrefix[r + 1] -
                    (valPrefix[l] * pow10[digits]) % MOD + MOD) % MOD;

            long sum = sumPrefix[r + 1] - sumPrefix[l];

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}