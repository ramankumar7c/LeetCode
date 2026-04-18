class Solution {
    public int mirrorDistance(int n) {
        int reverseN = reverse(n);
        return Math.abs(n - reverseN);
    }

    private int reverse(int n) {
        int reverse = 0;
        while (n > 0) {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        return reverse;
    }
}