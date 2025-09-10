class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[1] = 1;

        for (int day = 1; day <= n; day++) {
            long people = dp[day] % MOD;
            if (people == 0)
                continue;

            for (int start = day + delay; start < day + forget && start <= n; start++)
                dp[start] = (dp[start] + people) % MOD;
        }

        long ans = 0;
        for (int day = n - forget + 1; day <= n; day++)
            if (day > 0)
                ans = (ans + dp[day]) % MOD;

        return (int) ans;
    }
}