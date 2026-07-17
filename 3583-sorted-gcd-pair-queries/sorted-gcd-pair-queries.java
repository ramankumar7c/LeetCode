class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums)
            freq[x]++;

        long[] divisible = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            for (int multiple = g; multiple <= max; multiple += g) {
                divisible[g] += freq[multiple];
            }
        }

        long[] exact = new long[max + 1];

        for (int g = max; g >= 1; g--) {
            long cnt = divisible[g];
            exact[g] = cnt * (cnt - 1) / 2;

            for (int multiple = g * 2; multiple <= max; multiple += g)
                exact[g] -= exact[multiple];
        }

        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++)
            prefix[g] = prefix[g - 1] + exact[g];

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1;

            int lo = 1, hi = max;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (prefix[mid] >= k)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            ans[i] = lo;
        }

        return ans;
    }
}