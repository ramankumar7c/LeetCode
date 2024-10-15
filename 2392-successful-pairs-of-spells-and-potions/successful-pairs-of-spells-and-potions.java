class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] pairs = new int[n];

        for (int i = 0; i < n; i++) {
            int left = 0, right = m;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if ((long) spells[i] * potions[mid] >= success)
                    right = mid;
                else
                    left = mid + 1;
            }
            pairs[i] = m - left;
        }
        return pairs;
    }
}