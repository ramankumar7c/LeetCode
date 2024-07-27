class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int ALPHABET_SIZE = 26;
        long[][] adjMatrix = new long[ALPHABET_SIZE][ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            Arrays.fill(adjMatrix[i], Long.MAX_VALUE);
            adjMatrix[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            adjMatrix[u][v] = Math.min(adjMatrix[u][v], cost[i]);
        }
        for (int k = 0; k < ALPHABET_SIZE; k++)
            for (int i = 0; i < ALPHABET_SIZE; i++)
                for (int j = 0; j < ALPHABET_SIZE; j++)
                    if (adjMatrix[i][k] < Long.MAX_VALUE && adjMatrix[k][j] < Long.MAX_VALUE)
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i))
                continue;
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            if (adjMatrix[u][v] == Long.MAX_VALUE)
                return -1;
            totalCost += adjMatrix[u][v];
        }
        return totalCost;
    }
}