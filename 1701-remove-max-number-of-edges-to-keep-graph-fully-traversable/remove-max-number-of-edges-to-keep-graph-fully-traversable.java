class UnionFind {
    private int count;
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        if (parent[p] != p)
            parent[p] = find(parent[p]);

        return parent[p];
    }

    public boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return false;
        if (rank[rootP] > rank[rootQ])
            parent[rootQ] = rootP;
        else if (rank[rootP] < rank[rootQ])
            parent[rootP] = rootQ;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
        return true;
    }

    public int getCount() {
        return count;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int totalEdgesUsed = 0;

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (alice.union(edge[1] - 1, edge[2] - 1)) {
                    bob.union(edge[1] - 1, edge[2] - 1);
                    totalEdgesUsed++;
                }
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (alice.union(edge[1] - 1, edge[2] - 1))
                    totalEdgesUsed++;
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (bob.union(edge[1] - 1, edge[2] - 1))
                    totalEdgesUsed++;
            }
        }

        if (alice.getCount() != 1 || bob.getCount() != 1)
            return -1;

        return edges.length - totalEdgesUsed;
    }
}