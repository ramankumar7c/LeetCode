class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int appleWeight = 0;
        for (int a : apple)
            appleWeight += a;

        Arrays.sort(capacity);

        int count = 0;
        int capWeight = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            capWeight += capacity[i];
            count++;
            if (capWeight >= appleWeight)
                break;
        }
        return count;
    }
}