class Solution {
    public long minEnd(int n, int x) {
        long k = n - 1;
        long ans = x;
        long shift = 0;

        while (k > 0) {
            while (((ans >> shift) & 1) == 1) {
                shift++;
            }
            if ((k & 1) == 1)
                ans |= 1L << shift;

            k >>= 1;
            shift++;
        }
        return ans;
    }
}