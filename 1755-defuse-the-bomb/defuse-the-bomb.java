class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];

        if (k == 0)
            return ans;

        int sum = 0;
        int absK = Math.abs(k);

        if (k > 0)
            for (int i = 1; i <= k; i++)
                sum += code[i % n];

        else
            for (int i = 1; i <= absK; i++)
                sum += code[(n - i) % n];

        for (int i = 0; i < n; i++) {
            ans[i] = sum;

            if (k > 0) {
                sum -= code[(i + 1) % n];
                sum += code[(i + 1 + k) % n];
            }
            else {
                sum -= code[(n + i - absK) % n];
                sum += code[(n + i) % n];
            }
        }
        return ans;
    }
}
