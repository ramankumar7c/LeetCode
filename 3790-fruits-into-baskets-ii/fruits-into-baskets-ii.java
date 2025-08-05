class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced = 0;
        int n = baskets.length;
        boolean[] used = new boolean[n];

        for (int f : fruits) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (baskets[j] >= f && used[j] == false) {
                    used[j] = true;
                    placed = true;
                    break;
                }
            }
            if (placed == false)
                unplaced++;
        }
        return unplaced;
    }
}