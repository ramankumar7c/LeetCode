class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            java.util.Arrays.fill(row, -1);
        }

        int sr = 0, sc = 0, litterCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);

                if (c == 'S') {
                    sr = i;
                    sc = j;
                } else if (c == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int allMask = (1 << litterCount) - 1;

        boolean[][][][] visited = new boolean[m][n][1 << litterCount][energy + 1];

        java.util.ArrayDeque<int[]> queue = new java.util.ArrayDeque<>();
        queue.offer(new int[] { sr, sc, 0, energy, 0 });
        visited[sr][sc][0][energy] = true;

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int r = cur[0];
            int c = cur[1];
            int mask = cur[2];
            int e = cur[3];
            int moves = cur[4];

            if (mask == allMask) {
                return moves;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n ||
                        classroom[nr].charAt(nc) == 'X' || e == 0) {
                    continue;
                }

                int ne = e - 1;
                int nmask = mask;

                if (litterId[nr][nc] != -1) {
                    nmask |= 1 << litterId[nr][nc];
                }

                if (classroom[nr].charAt(nc) == 'R') {
                    ne = energy;
                }

                if (!visited[nr][nc][nmask][ne]) {
                    visited[nr][nc][nmask][ne] = true;
                    queue.offer(new int[] { nr, nc, nmask, ne, moves + 1 });
                }
            }
        }

        return -1;
    }
}