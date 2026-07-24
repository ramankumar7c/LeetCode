class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int MAX = 2048;

        boolean[][] dp = new boolean[4][MAX];
        dp[0][0] = true;

        for (int val : nums) {
            boolean[][] next = new boolean[4][MAX];

            for (int c = 0; c <= 3; c++)
                System.arraycopy(dp[c], 0, next[c], 0, MAX);

            for (int used = 0; used <= 3; used++) {
                for (int x = 0; x < MAX; x++) {
                    if (!dp[used][x])
                        continue;

                    if (used + 1 <= 3)
                        next[used + 1][x ^ val] = true;

                    if (used + 2 <= 3)
                        next[used + 2][x] = true;

                    if (used + 3 <= 3)
                        next[used + 3][x ^ val] = true;
                }
            }

            dp = next;
        }

        int ans = 0;
        for (boolean b : dp[3])
            if (b)
                ans++;

        return ans;
    }
}