class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        long INF = (long) 1e18;

        Map<Integer, Set<String>> byLen = new HashMap<>();
        Set<String> all = new HashSet<>();

        for (String s : original) {
            byLen.computeIfAbsent(s.length(), k -> new HashSet<>()).add(s);
            all.add(s);
        }
        for (String s : changed) {
            byLen.computeIfAbsent(s.length(), k -> new HashSet<>()).add(s);
            all.add(s);
        }

        Map<String, Integer> id = new HashMap<>();
        int idx = 0;
        for (String s : all)
            id.put(s, idx++);

        int m = idx;
        long[][] dist = new long[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < m; k++)
            for (int i = 0; i < m; i++)
                if (dist[i][k] != INF)
                    for (int j = 0; j < m; j++)
                        if (dist[k][j] != INF)
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (source.charAt(i) == target.charAt(i))
                dp[i] = dp[i + 1];

            for (int len : byLen.keySet()) {
                if (i + len > n)
                    continue;

                String sSub = source.substring(i, i + len);
                String tSub = target.substring(i, i + len);

                Integer u = id.get(sSub);
                Integer v = id.get(tSub);

                if (u == null || v == null)
                    continue;
                if (dist[u][v] == INF)
                    continue;

                dp[i] = Math.min(dp[i], dist[u][v] + dp[i + len]);
            }
        }
        return dp[0] == INF ? -1 : dp[0];
    }
}