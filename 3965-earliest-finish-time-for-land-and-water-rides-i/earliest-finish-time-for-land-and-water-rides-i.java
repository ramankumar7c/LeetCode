class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        long ans = Math.min(solve(landStartTime, landDuration, waterStartTime, waterDuration),
                solve(waterStartTime, waterDuration, landStartTime, landDuration));

        return (int) ans;
    }

    private long solve(int[] firstStart, int[] firstDur,
            int[] secondStart, int[] secondDur) {

        int m = secondStart.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDur[i];
        }

        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

        int[] starts = new int[m];
        long[] prefMinDur = new long[m];
        long[] suffMinStartPlusDur = new long[m];

        for (int i = 0; i < m; i++)
            starts[i] = rides[i][0];

        prefMinDur[0] = rides[0][1];
        for (int i = 1; i < m; i++)
            prefMinDur[i] = Math.min(prefMinDur[i - 1], rides[i][1]);

        suffMinStartPlusDur[m - 1] = (long) rides[m - 1][0] + rides[m - 1][1];
        for (int i = m - 2; i >= 0; i--)
            suffMinStartPlusDur[i] = Math.min(suffMinStartPlusDur[i + 1], (long) rides[i][0] + rides[i][1]);

        long res = Long.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {
            long finishFirst = (long) firstStart[i] + firstDur[i];

            int pos = upperBound(starts, finishFirst);

            if (pos > 0)
                res = Math.min(res, finishFirst + prefMinDur[pos - 1]);

            if (pos < m)
                res = Math.min(res, suffMinStartPlusDur[pos]);
        }
        return res;
    }

    private int upperBound(int[] arr, long target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }
}