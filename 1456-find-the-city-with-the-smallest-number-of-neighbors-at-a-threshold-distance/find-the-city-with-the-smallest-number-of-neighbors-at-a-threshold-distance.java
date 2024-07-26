class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] graph = buildGraph(n, edges);
        int minCitiesCount = n;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int citiesCount = countCitiesWithinThreshold(i, graph, distanceThreshold);
            if (citiesCount <= minCitiesCount) {
                resultCity = i;
                minCitiesCount = citiesCount;
            }
        }
        return resultCity;
    }

    private List<int[]>[] buildGraph(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new int[] { v, w });
            graph[v].add(new int[] { u, w });
        }
        return graph;
    }

    private int countCitiesWithinThreshold(int start, List<int[]>[] graph, int distanceThreshold) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[] { start, 0 });
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int d = current[1];

            if (d > distanceThreshold)
                break;

            for (int[] neighbour : graph[u]) {
                int v = neighbour[0];
                int weight = neighbour[1];
                if (d + weight < dist[v]) {
                    dist[v] = d + weight;
                    pq.add(new int[] { v, dist[v] });
                }
            }
        }
        int count = 0;
        for (int d : dist) {
            if (d <= distanceThreshold)
                count++;
        }
        return count;
    }
}