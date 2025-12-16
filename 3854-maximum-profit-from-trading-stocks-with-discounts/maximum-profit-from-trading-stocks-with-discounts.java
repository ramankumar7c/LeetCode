class Solution {
    int n, budget;
    int[] present, future;
    List<Integer>[] tree;

    Map<Long, int[][]> memo = new HashMap<>();

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.n = n;
        this.present = present;
        this.future = future;
        this.budget = budget;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++)
            tree[i] = new ArrayList<>();

        for (int[] e : hierarchy)
            tree[e[0] - 1].add(e[1] - 1);

        int[][] res = dp(0, -1);

        int ans = 0;
        for (int b = 0; b <= budget; b++)
            ans = Math.max(ans, res[0][b]);

        return ans;
    }

    private int[][] dp(int u, int parent) {
        long key = (((long) u) << 32) ^ parent;
        if (memo.containsKey(key))
            return memo.get(key);

        int[] noDiscount = new int[budget + 1];
        int[] withDiscount = new int[budget + 1];
        Arrays.fill(noDiscount, 0);
        Arrays.fill(withDiscount, 0);

        for (int v : tree[u]) {
            if (v == parent)
                continue;

            int[][] child = dp(v, u);
            noDiscount = merge(noDiscount, child[0]);
            withDiscount = merge(withDiscount, child[1]);
        }

        int[] newDp0 = noDiscount.clone();
        int[] newDp1 = noDiscount.clone();

        int fullCost = present[u];
        for (int b = fullCost; b <= budget; b++) {
            int profit = future[u] - fullCost;
            newDp0[b] = Math.max(newDp0[b], withDiscount[b - fullCost] + profit);
        }

        int halfCost = present[u] / 2;
        for (int b = halfCost; b <= budget; b++) {
            int profit = future[u] - halfCost;
            newDp1[b] = Math.max(newDp1[b], withDiscount[b - halfCost] + profit);
        }

        int[][] result = new int[][] { newDp0, newDp1 };
        memo.put(key, result);
        return result;
    }

    private int[] merge(int[] A, int[] B) {
        int[] merged = new int[A.length];
        Arrays.fill(merged, Integer.MIN_VALUE);

        for (int i = 0; i < A.length; i++)
            for (int j = 0; j + i < A.length; j++)
                merged[i + j] = Math.max(merged[i + j], A[i] + B[j]);

        return merged;
    }
}