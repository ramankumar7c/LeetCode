class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int len = arr.length;
        double l = 0.0;
        double r = 1.0;

        while (l < r) {
            double m = (l + r) / 2.0;
            int fractionsNo_GreaterThanM = 0;
            int p = 0;
            int q = 1;

            for (int i = 0, j = 1; i < len; i++) {
                while (j < len && arr[i] > m * arr[j])
                    j++;
                if (j == len)
                    break;
                fractionsNo_GreaterThanM += len - j;
                if (p * arr[j] < q * arr[i]) {
                    p = arr[i];
                    q = arr[j];
                }
            }
            if (fractionsNo_GreaterThanM == k)
                return new int[] { p, q };
            if (fractionsNo_GreaterThanM > k)
                r = m;
            else
                l = m;
        }
        throw new IllegalArgumentException();
    }
}