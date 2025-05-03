class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int minSwaps = Integer.MAX_VALUE;
        int n = tops.length;

        for (int candidate = 1; candidate <= 6; candidate++) {
            int topSwaps = 0;
            int bottomSwaps = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (tops[i] != candidate && bottoms[i] != candidate) {
                    possible = false;
                    break;
                }
                if (tops[i] != candidate)
                    topSwaps++;

                if (bottoms[i] != candidate)
                    bottomSwaps++;
            }
            if (possible)
                minSwaps = Math.min(minSwaps, Math.min(topSwaps, bottomSwaps));
        }
        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
    }
}