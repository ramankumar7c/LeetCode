class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1;
        int num = n;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }
        return num % (sum + product) == 0;
    }
}