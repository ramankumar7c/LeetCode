class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0)
            return -1;

        int mod = 0;
        for (int length = 1; length <= k; length++) {
            mod = (mod * 10 + 1) % k;
            if (mod == 0)
                return length;
        }
        return -1;
    }
}