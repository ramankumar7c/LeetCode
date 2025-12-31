class Solution {
    int[] parent, rank;

    public int latestDayToCross(int row, int col, int[][] cells) {
        int total = row * col;
        int top = total;
        int bottom = total + 1;

        parent = new int[total + 2];
        rank = new int[total + 2];

        for (int i = 0; i < total + 2; i++)
            parent[i] = i;

        boolean[][] land = new boolean[row][col];

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int day = cells.length - 1; day >= 0; day--) {
            int r = cells[day][0] - 1;
            int c = cells[day][1] - 1;
            land[r][c] = true;

            int id = r * col + c;

            if (r == 0)
                union(id, top);
            if (r == row - 1)
                union(id, bottom);

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && land[nr][nc])
                    union(id, nr * col + nc);
            }

            if (find(top) == find(bottom))
                return day;
        }
        return 0;
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py)
            return;

        if (rank[px] < rank[py])
            parent[px] = py;
        else if (rank[px] > rank[py])
            parent[py] = px;
        else {
            parent[py] = px;
            rank[px]++;
        }
    }
}