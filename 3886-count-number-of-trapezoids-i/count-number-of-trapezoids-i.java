class Solution {
    static long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int[] p : points)
            freq.put(p[1], freq.getOrDefault(p[1], 0) + 1);

        long S = 0;
        long SS = 0;

        for (int count : freq.values()) {
            if (count >= 2) {
                long pairs = (long) count * (count - 1) / 2;
                pairs %= MOD;

                S = (S + pairs) % MOD;
                SS = (SS + (pairs * pairs) % MOD) % MOD;
            }
        }

        long total = (S * S % MOD - SS + MOD) % MOD;
        long inv2 = (MOD + 1) / 2;
        total = total * inv2 % MOD;

        return (int) total;
    }
}