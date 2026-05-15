class Solution {
    public boolean validDigit(int n, int x) {
        String str = String.valueOf(n);
        char digit = (char) (x + '0');

        return str.charAt(0) != digit && str.indexOf(digit) != -1;
    }
}