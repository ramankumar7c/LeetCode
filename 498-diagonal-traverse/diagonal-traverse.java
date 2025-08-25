class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int r = 0, c = 0, dir = 1;
        int[] ans = new int[m * n];

        for (int i = 0; i < m * n; i++) {
            ans[i] = mat[r][c];
            if (dir == 1) {
                if (c == m - 1) {
                    dir = -1;
                    r++;
                } else if (r == 0) {
                    dir = -1;
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else {
                if (r == n - 1) {
                    dir = 1;
                    c++;
                } else if (c == 0) {
                    dir = 1;
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return ans;
    }
}