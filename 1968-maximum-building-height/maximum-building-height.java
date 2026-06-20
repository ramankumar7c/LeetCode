class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;

        int[][] arr = new int[m + 2][2];
        arr[0] = new int[] { 1, 0 };

        for (int i = 0; i < m; i++)
            arr[i + 1] = restrictions[i];

        arr[m + 1] = new int[] { n, n - 1 };

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < arr.length; i++) {
            arr[i][1] = Math.min(arr[i][1], arr[i - 1][1] + (arr[i][0] - arr[i - 1][0]));
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i][1] = Math.min(arr[i][1], arr[i + 1][1] + (arr[i + 1][0] - arr[i][0]));
        }

        int ans = 0;

        for (int i = 1; i < arr.length; i++) {
            int id1 = arr[i - 1][0];
            int h1 = arr[i - 1][1];

            int id2 = arr[i][0];
            int h2 = arr[i][1];

            int d = id2 - id1;

            ans = Math.max(ans, (h1 + h2 + d) / 2);
        }
        return ans;
    }
}