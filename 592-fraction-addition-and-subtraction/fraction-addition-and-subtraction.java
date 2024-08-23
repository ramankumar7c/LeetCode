class Solution {
    public String fractionAddition(String expression) {
        int A = 0, B = 1;
        int i = 0;
        while (i < expression.length()) {
            int sign = 1;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-')
                sign = expression.charAt(i++) == '-' ? -1 : 1;

            int numerator = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i)))
                numerator = numerator * 10 + (expression.charAt(i++) - '0');
            numerator *= sign;
            i++;
            int denominator = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i)))
                denominator = denominator * 10 + (expression.charAt(i++) - '0');

            A = A * denominator + numerator * B;
            B *= denominator;

            int gcdValue = gcd(Math.abs(A), B);
            A /= gcdValue;
            B /= gcdValue;
        }
        return A + "/" + B;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}