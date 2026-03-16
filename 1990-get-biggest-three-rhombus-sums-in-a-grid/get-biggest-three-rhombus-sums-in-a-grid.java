class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] diag1 = new int[m + 1][n + 1];
        int[][] diag2 = new int[m + 1][n + 2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diag1[i + 1][j + 1] = grid[i][j] + diag1[i][j];
                diag2[i + 1][j] = grid[i][j] + diag2[i][j + 1];
            }
        }

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                set.add(grid[i][j]);

                int maxSize = Math.min(
                        Math.min(i, m - 1 - i),
                        Math.min(j, n - 1 - j));

                for (int k = 1; k <= maxSize; k++) {

                    int r1 = i - k, c1 = j;
                    int r2 = i, c2 = j + k;
                    int r3 = i + k, c3 = j;
                    int r4 = i, c4 = j - k;

                    int sum = 0;

                    sum += diag1[r2 + 1][c2 + 1] - diag1[r1][c1];
                    sum += diag2[r3 + 1][c3] - diag2[r2][c2 + 1];
                    sum += diag1[r3 + 1][c3 + 1] - diag1[r4][c4];
                    sum += diag2[r4 + 1][c4] - diag2[r1][c1 + 1];

                    sum -= grid[r1][c1];
                    sum -= grid[r2][c2];
                    sum -= grid[r3][c3];
                    sum -= grid[r4][c4];

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] res = new int[size];

        for (int i = 0; i < size; i++) {
            res[i] = set.pollLast();
        }

        return res;
    }
}