class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int ans = 0;
        for (int[] domino : dominoes) {
            int a = domino[0], b = domino[1];
            int key = Math.min(a, b) * 10 + Math.max(a, b);
            ans += count[key];
            count[key]++;
        }
        return ans;
    }
}