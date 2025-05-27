class Solution {
    public int differenceOfSums(int n, int m) {
        int Div3 = 0, notDiv3 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0)
                Div3 += i;
            else
                notDiv3 += i;
        }
        return notDiv3 - Div3;
    }
}