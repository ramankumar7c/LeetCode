class Solution {
    private static final int MOD = 1_000_000_007;
    private int m;
    private int n;
    private Map<Integer, Map<Integer, Integer>> memo;

    public int colorTheGrid(int m, int n) {
        this.m = m;
        this.n = n;
        this.memo = new HashMap<>();
        return dfs(0, 0, 0);
    }

    private int dfs(int row, int col, int prevColMask) {
        if (col == n)
            return 1;
        if (row == m)
            return dfs(0, col + 1, prevColMask);

        if (row == 0 && memo.containsKey(col) && memo.get(col).containsKey(prevColMask))
            return memo.get(col).get(prevColMask);

        int res = 0;
        int upColor = (row == 0) ? 0 : getColor(prevColMask, row - 1);
        int leftColor = (col == 0) ? 0 : getColor(prevColMask, row);

        for (int color = 1; color <= 3; color++) {
            if (color == upColor || color == leftColor)
                continue;
            int newMask = setColor(prevColMask, row, color);
            res = (res + dfs(row + 1, col, newMask)) % MOD;
        }

        if (row == 0)
            memo.computeIfAbsent(col, k -> new HashMap<>()).put(prevColMask, res);

        return res;
    }

    private int getColor(int mask, int pos) {
        return (mask >> (pos * 2)) & 3;
    }

    private int setColor(int mask, int pos, int color) {
        mask &= ~(3 << (pos * 2));
        return mask | (color << (pos * 2));
    }
}