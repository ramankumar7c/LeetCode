class Solution {
    public int passThePillow(int n, int time) {
        time = time % (2 * (n - 1));
        if (time < n)
            return time + 1;
        else
            return 2 * n - time - 1;
    }
}