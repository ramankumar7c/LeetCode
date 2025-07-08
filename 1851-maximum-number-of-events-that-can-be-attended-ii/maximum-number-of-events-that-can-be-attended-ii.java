class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        Integer[][] dp = new Integer[events.length][k + 1];

        return helper(events, 0, k, dp);
    }

    private int helper(int[][] events, int index, int remaining, Integer[][] dp) {
        if (index >= events.length || remaining == 0)
            return 0;

        if (dp[index][remaining] != null)
            return dp[index][remaining];

        int skip = helper(events, index + 1, remaining, dp);

        int nextIndex = findNextEvent(events, events[index][1], index + 1);
        int attend = events[index][2] + helper(events, nextIndex, remaining - 1, dp);

        dp[index][remaining] = Math.max(skip, attend);
        return dp[index][remaining];
    }

    private int findNextEvent(int[][] events, int endTime, int start) {
        int left = start;
        int right = events.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] > endTime)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}