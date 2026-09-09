class Solution {
    public long countCommas(long n) {
        long ans = 0;

        if (n >= 1000) {
            ans += Math.min(n, 999999L) - 1000 + 1;
        }

        if (n >= 1000000) {
            ans += 2L * (Math.min(n, 999999999L) - 1000000 + 1);
        }

        if (n >= 1000000000L) {
            ans += 3L * (Math.min(n, 999999999999L) - 1000000000L + 1);
        }

        if (n >= 1000000000000L) {
            ans += 4L * (Math.min(n, 999999999999999L) - 1000000000000L + 1);
        }

        if (n >= 1000000000000000L) {
            ans += 5L;
        }

        return ans;
    }
}