class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        final int m = text1.length();
        final int n = text2.length();

        int[] dp = new int[n + 1];
        int[] prev = new int[n + 1];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (text1.charAt(i) == text2.charAt(j))
                    dp[j + 1] = 1 + prev[j];
                else
                    dp[j + 1] = Math.max(dp[j], prev[j + 1]);
            }
            System.arraycopy(dp, 0, prev, 0, n + 1);
        }

        return dp[n];
    }
}
