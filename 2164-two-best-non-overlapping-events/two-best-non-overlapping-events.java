class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int[] suffixMax = new int[n + 1];
        for (int i = n - 1; i >= 0; i--)
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int value1 = events[i][2];
            int nextIdx = findNextEvent(events, events[i][1] + 1);
            ans = Math.max(ans, value1 + suffixMax[nextIdx]);
        }
        return ans;
    }

    private int findNextEvent(int[][] events, int target) {
        int l = 0, r = events.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (events[mid][0] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}