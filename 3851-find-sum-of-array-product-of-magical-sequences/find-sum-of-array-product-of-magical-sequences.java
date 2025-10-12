class Solution {
    private static final int MOD = 1_000_000_007;
    private long[][] pow;
    private int[][] comb;
    private Integer[][][][] mem;
    private int[] nums;

    public int magicalSum(int m, int k, int[] nums) {
        this.nums = nums;
        int n = nums.length;
        this.comb = getComb(m);
        this.pow = new long[n][m + 1];

        for (int i = 0; i < n; i++) {
            pow[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                pow[i][j] = pow[i][j - 1] * nums[i] % MOD;
            }
        }

        this.mem = new Integer[m + 1][k + 1][n + 1][m + 2];
        return dp(m, k, 0, 0);
    }

    private int dp(int m, int k, int i, int carry) {
        if (m < 0 || k < 0 || (m + Integer.bitCount(carry) < k))
            return 0;
        if (m == 0)
            return k == Integer.bitCount(carry) ? 1 : 0;
        if (i == nums.length)
            return 0;
        if (mem[m][k][i][carry] != null)
            return mem[m][k][i][carry];

        long res = 0;
        for (int count = 0; count <= m; count++) {
            int newCarry = carry + count;
            long contribution = (long) comb[m][count] * pow[i][count] % MOD;
            res = (res +
                    dp(m - count, k - (newCarry % 2), i + 1, newCarry / 2) * contribution) % MOD;
        }
        return mem[m][k][i][carry] = (int) res;
    }

    private int[][] getComb(int n) {
        int[][] c = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            c[i][0] = c[i][i] = 1;
            for (int j = 1; j < i; j++) {
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % MOD;
            }
        }
        return c;
    }
}