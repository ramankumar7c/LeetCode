class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N == 0)
            return 1;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        if (N % 2 == 1)
            return x * myPow(x, (int) (N - 1));
        return myPow(x * x, (int) (N / 2));
    }
}