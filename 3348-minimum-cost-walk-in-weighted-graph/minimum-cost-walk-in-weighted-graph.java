class UnionFind {
    private int[] parent;
    private int[] rank;
    private int[] weight;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
            weight[i] = (1 << 17) - 1;
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            int originalParent = parent[u];
            parent[u] = find(parent[u]);
            weight[u] &= weight[originalParent];
        }
        return parent[u];
    }

    public void unionByRank(int u, int v, int w) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) {
            weight[rootU] &= w;
            return;
        }
        if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
            weight[rootU] &= weight[rootV] & w;
        } else if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
            weight[rootV] &= weight[rootU] & w;
        } else {
            parent[rootV] = rootU;
            weight[rootU] &= weight[rootV] & w;
            rank[rootU]++;
        }
    }

    public int getMinCost(int u, int v) {
        if (u == v)
            return 0;
        int rootU = find(u);
        int rootV = find(v);
        return rootU == rootV ? weight[rootU] : -1;
    }
}

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            uf.unionByRank(u, v, w);
        }
        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int u = query[i][0];
            int v = query[i][1];
            ans[i] = uf.getMinCost(u, v);
        }
        return ans;
    }
}