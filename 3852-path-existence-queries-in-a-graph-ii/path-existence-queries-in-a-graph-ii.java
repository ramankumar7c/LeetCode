class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] pos = new int[n];
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = arr[i][0];
            pos[arr[i][1]] = i;
        }

        int[] comp = new int[n];
        comp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (sorted[i] - sorted[i - 1] <= maxDiff)
                comp[i] = comp[i - 1];
            else
                comp[i] = comp[i - 1] + 1;
        }

        int LOG = 17;
        int[][] jump = new int[LOG][n];

        int r = 0;
        for (int l = 0; l < n; l++) {
            while (r + 1 < n && sorted[r + 1] - sorted[l] <= maxDiff)
                r++;
            jump[0][l] = r;
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {
            int u = pos[queries[qi][0]];
            int v = pos[queries[qi][1]];

            if (u == v) {
                ans[qi] = 0;
                continue;
            }

            if (comp[u] != comp[v]) {
                ans[qi] = -1;
                continue;
            }

            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            int cur = u;
            int steps = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                if (jump[k][cur] < v) {
                    cur = jump[k][cur];
                    steps += (1 << k);
                }
            }

            ans[qi] = steps + 1;
        }

        return ans;
    }
}