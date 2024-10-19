class Solution {
    public char findKthBit(int n, int k) {
        boolean flip = false;
        while (n > 1) {
            int midIndex = (1 << (n - 1));
            if (k == midIndex)
                return flip ? '0' : '1';

            if (k > midIndex) {
                k = midIndex * 2 - k;
                flip = !flip;
            }
            n--;
        }
        return flip ? '1' : '0';
    }
}