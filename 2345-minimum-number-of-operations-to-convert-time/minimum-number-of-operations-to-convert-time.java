class Solution {
    public int convertTime(String current, String correct) {
        int[] ops = { 60, 15, 5, 1 };
        int diff = getMinutes(correct) - getMinutes(current);
        int ans = 0;

        for (int op : ops) {
            ans += diff / op;
            diff %= op;
        }

        return ans;
    }

    private int getMinutes(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }
}