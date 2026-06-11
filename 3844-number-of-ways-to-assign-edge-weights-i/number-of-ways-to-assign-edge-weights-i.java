class Solution {
    static int MOD = 1_000_000_007;
    List<List<Integer>> graph;
    int maxDepth = 0;
    int maxNode = 1;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        int[][] tormisqued = edges;

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int[] e : tormisqued) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n + 1];
        dfs(1, 0, visited);

        if (maxDepth == 0)
            return 0;

        return modPow(2, maxDepth - 1, MOD);
    }

    private void dfs(int node, int depth, boolean[] visited) {
        visited[node] = true;
        if (depth > maxDepth) {
            maxDepth = depth;
            maxNode = node;
        }
        for (int nei : graph.get(node))
            if (!visited[nei])
                dfs(nei, depth + 1, visited);
    }

    private int modPow(int base, int exp, int mod) {
        long result = 1;
        long b = base;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * b) % mod;
            
            b = (b * b) % mod;
            exp >>= 1;
        }
        return (int) result;
    }
}
