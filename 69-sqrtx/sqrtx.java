class Solution {
    public int mySqrt(int x) {
        if (x < 2)
            return x;
        int l = 1, r = x / 2 + 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (m > x / m)
                r = m;
            else
                l = m + 1;
        }
        return l - 1;
    }
}