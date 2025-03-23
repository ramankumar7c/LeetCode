class Solution {
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            graph[u].add(new int[] { v, w });
            graph[v].add(new int[] { u, w });
        }
        long INF = Long.MAX_VALUE;
        int MOD = 1_000_000_007;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        int[] ways = new int[n];
        Arrays.fill(ways, 0);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        minHeap.offer(new long[] { 0, 0 });
        while (!minHeap.isEmpty()) {
            long[] current = minHeap.poll();
            int u = (int) current[0];
            long d = current[1];

            if (d > dist[u])
                continue;

            for (int[] neighbour : graph[u]) {
                int v = neighbour[0];
                int w = neighbour[1];

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    ways[v] = ways[u];
                    minHeap.offer(new long[] { v, dist[v] });
                } else if (dist[u] + w == dist[v])
                    ways[v] = (ways[v] + ways[u]) % MOD;
            }
        }
        return ways[n - 1];
    }
}