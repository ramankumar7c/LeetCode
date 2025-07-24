class Solution {
    private int time = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; ++i)
            tree[i] = new ArrayList<>();

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        int[] xor = new int[n];
        int[] in = new int[n];
        int[] out = new int[n];

        dfs(0, -1, tree, nums, xor, in, out);

        int totalXor = xor[0];
        int minScore = Integer.MAX_VALUE;

        for (int i = 1; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int a = i, b = j;
                if (isAncestor(a, b, in, out)) {
                    int x = xor[b];
                    int y = xor[a] ^ xor[b];
                    int z = totalXor ^ xor[a];
                    minScore = Math.min(minScore, Math.max(x, Math.max(y, z)) - Math.min(x, Math.min(y, z)));
                } else if (isAncestor(b, a, in, out)) {
                    int x = xor[a];
                    int y = xor[b] ^ xor[a];
                    int z = totalXor ^ xor[b];
                    minScore = Math.min(minScore, Math.max(x, Math.max(y, z)) - Math.min(x, Math.min(y, z)));
                } else {
                    int x = xor[a];
                    int y = xor[b];
                    int z = totalXor ^ xor[a] ^ xor[b];
                    minScore = Math.min(minScore, Math.max(x, Math.max(y, z)) - Math.min(x, Math.min(y, z)));
                }
            }
        }

        return minScore;
    }

    private int dfs(int node, int parent, List<Integer>[] tree, int[] nums, int[] xor, int[] in, int[] out) {
        in[node] = time++;
        xor[node] = nums[node];
        for (int neighbor : tree[node]) {
            if (neighbor == parent)
                continue;
            xor[node] ^= dfs(neighbor, node, tree, nums, xor, in, out);
        }
        out[node] = time++;
        return xor[node];
    }

    private boolean isAncestor(int u, int v, int[] in, int[] out) {
        return in[u] < in[v] && out[v] < out[u];
    }
}