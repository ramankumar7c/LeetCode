class Solution {
    static final long MOD = 1_000_000_007;

    public int countPermutations(int[] comp) {
        int n = comp.length;

        int[] minParent = new int[n];
        Arrays.fill(minParent, -1);

        int minComp = comp[0];
        int minIdx = 0;

        for (int i = 1; i < n; i++) {

            if (minComp < comp[i])
                minParent[i] = minIdx;
            else
                return 0;

            if (comp[i] < minComp) {
                minComp = comp[i];
                minIdx = i;
            }
        }

        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < n; i++)
            bucket.add(new ArrayList<>());

        for (int i = 1; i < n; i++)
            bucket.get(minParent[i]).add(i);

        long ways = 1;
        Queue<Integer> available = new ArrayDeque<>();

        for (int x : bucket.get(0))
            available.add(x);

        int unlocked = 1;

        while (unlocked < n) {
            int A = available.size();
            if (A == 0)
                return 0;

            ways = (ways * A) % MOD;

            int pick = available.poll();
            unlocked++;

            for (int x : bucket.get(pick))
                available.add(x);
        }

        return (int) ways;
    }
}