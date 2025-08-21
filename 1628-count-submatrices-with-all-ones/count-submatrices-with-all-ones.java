class Solution {
    public int numSubmat(int[][] mat) {
        int ans = 0;
        int[] hist = new int[mat[0].length];

        for (int[] row : mat) {
            for (int i = 0; i < row.length; ++i)
                hist[i] = row[i] == 0 ? 0 : hist[i] + 1;
            ans += count(hist);
        }

        return ans;
    }

    private int count(int[] hist) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] dp = new int[hist.length]; // store counts
        int total = 0;

        for (int i = 0; i < hist.length; ++i) {
            while (!stack.isEmpty() && hist[stack.peek()] >= hist[i])
                stack.pop();

            if (!stack.isEmpty()) {
                int prev = stack.peek();
                dp[i] = dp[prev] + hist[i] * (i - prev);
            } else {
                dp[i] = hist[i] * (i + 1);
            }

            stack.push(i);
            total += dp[i]; // accumulate directly
        }

        return total;
    }
}