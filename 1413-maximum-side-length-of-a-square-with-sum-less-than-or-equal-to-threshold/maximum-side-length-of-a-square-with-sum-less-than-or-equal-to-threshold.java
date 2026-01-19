class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        int[][] ps = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                ps[i][j] = mat[i - 1][j - 1] + ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1];

        int low = 1, high = Math.min(m, n), ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (existsSquare(ps, mid, threshold)) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }

        return ans;
    }

    private boolean existsSquare(int[][] ps, int k, int threshold) {
        int m = ps.length - 1;
        int n = ps[0].length - 1;

        for (int i = k; i <= m; i++) {
            for (int j = k; j <= n; j++) {
                int sum = ps[i][j] - ps[i - k][j] - ps[i][j - k] + ps[i - k][j - k];

                if (sum <= threshold)
                    return true;
            }
        }
        return false;
    }
}