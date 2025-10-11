import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> count = new HashMap<>();

        for (final int damage : power)
            count.merge(damage, 1, Integer::sum);

        List<Integer> uniqueDamages = getSortedUniqueDamages(count);
        final int n = uniqueDamages.size();
        if (n == 0)
            return 0;

        // dp[i][0] = max total damage up to i if we skip damage i
        // dp[i][1] = max total damage up to i if we take damage i
        long[][] dp = new long[n][2];

        final int first = uniqueDamages.get(0);
        dp[0][0] = 0;
        dp[0][1] = (long) first * count.get(first);

        for (int i = 1; i < n; ++i) {
            final int damage = uniqueDamages.get(i);
            final long damageValue = (long) damage * count.get(damage);

            // Option 1: skip this damage
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);

            // Option 2: take this damage — find last compatible index j
            int j = i - 1;
            while (j >= 0 && damage - uniqueDamages.get(j) <= 2)
                j--;

            long include = damageValue + (j >= 0 ? Math.max(dp[j][0], dp[j][1]) : 0);
            dp[i][1] = include;
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    private List<Integer> getSortedUniqueDamages(Map<Integer, Integer> count) {
        List<Integer> uniqueDamages = new ArrayList<>(count.keySet());
        Collections.sort(uniqueDamages);
        return uniqueDamages;
    }
}