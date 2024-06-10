class Solution {
    public int divide(int dividend, int divisor) {
        long quotient = dividend / divisor;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        else if (quotient > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (quotient < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int) quotient;
    }
}