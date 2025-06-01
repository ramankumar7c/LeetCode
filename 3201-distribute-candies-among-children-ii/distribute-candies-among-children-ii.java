class Solution {
    public long distributeCandies(int n, int limit) {
        long total = comb(n + 2, 2);
        long oneExceeds = comb(n - (limit + 1) + 2, 2);
        long twoExceed = comb(n - 2 * (limit + 1) + 2, 2);
        long threeExceed = comb(n - 3 * (limit + 1) + 2, 2);

        return total - 3 * oneExceeds + 3 * twoExceed - threeExceed;
    }

    private long comb(int n, int k) {
        if (n < k)
            return 0;
        long res = 1;
        for (int i = 1; i <= k; i++)
            res = res * (n - k + i) / i;

        return res;
    }
}