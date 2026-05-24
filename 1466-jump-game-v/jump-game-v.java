class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, arr, d, dp));
        }

        return ans;
    }

    private int dfs(int i, int[] arr, int d, int[] dp) {
        if (dp[i] != 0) {
            return dp[i];
        }

        int n = arr.length;
        int max = 1;

        for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {

            if (arr[j] >= arr[i]) {
                break;
            }

            max = Math.max(max, 1 + dfs(j, arr, d, dp));
        }

        for (int j = i - 1; j >= Math.max(0, i - d); j--) {

            if (arr[j] >= arr[i]) {
                break;
            }

            max = Math.max(max, 1 + dfs(j, arr, d, dp));
        }

        dp[i] = max;
        return max;
    }
}