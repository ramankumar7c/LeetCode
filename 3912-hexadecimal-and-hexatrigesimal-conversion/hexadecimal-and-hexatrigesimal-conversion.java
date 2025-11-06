class Solution {
    public String concatHex36(int n) {
        long square = (long) n * n;
        long cube = (long) n * n * n;

        String hexadecimal = Long.toString(square, 16).toUpperCase();
        String hexatrigesimal = Long.toString(cube, 36).toUpperCase();

        return hexadecimal + hexatrigesimal;
    }
}