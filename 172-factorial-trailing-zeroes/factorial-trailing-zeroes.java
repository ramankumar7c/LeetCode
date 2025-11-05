class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    private int fact(int n) {
        if (n <= 1)
            return 1;
        return n * fact(n - 1);
    }
}