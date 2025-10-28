class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while (l < r) {
            int m = (l + r) / 2;
            if (m >= num / m)
                r = m;
            else
                l = m + 1;
        }
        return l * l == num;
    }
}