class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = getMaxPile(piles);

        while (l < r) {
            int m = (l + r) / 2;
            if (eatHours(piles, m) <= h)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    private int eatHours(int[] piles, int m) {
        int hours = 0;
        for (int pile : piles)
            hours += (pile + m - 1) / m;

        return hours;
    }

    private int getMaxPile(int[] piles) {
        int max = piles[0];
        for (int pile : piles)
            if (pile > max)
                max = pile;

        return max;
    }
}