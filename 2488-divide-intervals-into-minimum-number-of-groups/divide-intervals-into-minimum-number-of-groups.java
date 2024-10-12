class Solution {
    public int minGroups(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int groups = 0, activeIntervals = 0;
        int i = 0, j = 0;

        while (i < start.length) {
            if (start[i] <= end[j]) {
                activeIntervals++;
                groups = Math.max(groups, activeIntervals);
                i++;
            } else {
                activeIntervals--;
                j++;
            }
        }
        return groups;
    }
}