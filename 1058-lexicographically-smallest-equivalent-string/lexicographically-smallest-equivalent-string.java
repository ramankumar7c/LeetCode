class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++)
            parent[i] = i;

        for (int i = 0; i < s1.length(); i++) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            union(parent, u, v);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int root = find(parent, c - 'a');
            sb.append((char) ('a' + root));
        }
        return sb.toString();
    }

    private int find(int[] parent, int u) {
        if (parent[u] != u)
            parent[u] = find(parent, parent[u]);
        return parent[u];
    }

    private void union(int[] parent, int u, int v) {
        int rootU = find(parent, u);
        int rootV = find(parent, v);

        if (rootU < rootV)
            parent[rootV] = rootU;
        else if (rootU > rootV)
            parent[rootU] = rootV;
    }
}