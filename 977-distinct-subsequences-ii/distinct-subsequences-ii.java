class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1_000_000_007L;

        int n = s.length();

        long[] dp = new long[n + 1];
        dp[0] = 1;

        int[] last = new int[26];

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            int idx = c - 'a';

            dp[i] = (2 * dp[i - 1]) % MOD;

            if (last[idx] != 0)
                dp[i] = (dp[i] - dp[last[idx] - 1] + MOD) % MOD;

            last[idx] = i;
        }
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}