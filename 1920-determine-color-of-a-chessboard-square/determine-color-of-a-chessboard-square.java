class Solution {
    public boolean squareIsWhite(String coordinates) {
        char a = coordinates.charAt(0);
        char b = coordinates.charAt(1);
        int x = a;
        int y = b - '0';

        return (x + y) % 2 == 1;
    }
}