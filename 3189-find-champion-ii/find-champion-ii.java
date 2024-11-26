class Solution {
    public int findChampion(int n, int[][] edges) {
        Set<Integer> potentialChampions = new HashSet<>();
        for (int i = 0; i < n; i++)
            potentialChampions.add(i);

        for (int[] edge : edges) {
            int v = edge[1];
            potentialChampions.remove(v);
        }
        if (potentialChampions.size() == 1)
            return potentialChampions.iterator().next();

        return -1;
    }
}