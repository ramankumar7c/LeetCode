class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, prob));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, prob));
        }
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey()));
        pq.add(new Pair<>(1.0, start));

        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        while (!pq.isEmpty()) {
            Pair<Double, Integer> current = pq.poll();
            double prob = current.getKey();
            int u = current.getValue();

            if (u == end)
                return prob;

            if (prob < maxProb[u])
                continue;

            for (Pair<Integer, Double> neighbour : graph.getOrDefault(u, new ArrayList<>())) {
                int v = neighbour.getKey();
                double edgeProb = neighbour.getValue();

                if (maxProb[v] < maxProb[u] * edgeProb) {
                    maxProb[v] = maxProb[u] * edgeProb;
                    pq.add(new Pair<>(maxProb[v], v));
                }
            }
        }
        return 0.0;
    }
}