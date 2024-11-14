class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = getMax(quantities);

        while (l < r) {
            int m = (l + r) / 2;
            if (numStores(quantities, m) <= n)
                r = m;
            else
                l = m + 1;
        }

        return l;
    }

    private int getMax(int[] quantities) {
        int max = quantities[0];
        for (int quantity : quantities)
            if (quantity > max)
                max = quantity;

        return max;
    }

    private int numStores(int[] quantities, int m) {
        int stores = 0;
        for (int quantity : quantities)
            stores += (quantity - 1) / m + 1;

        return stores;
    }
}