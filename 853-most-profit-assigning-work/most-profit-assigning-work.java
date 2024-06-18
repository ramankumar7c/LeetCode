class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        Arrays.sort(worker);

        int ans = 0;
        int maxProfit = 0;
        int j = 0;

        for (int w : worker) {
            while (j < n && w >= jobs[j][0]) {
                maxProfit = Math.max(maxProfit, jobs[j][1]);
                j++;
            }
            ans += maxProfit;
        }
        return ans;
    }
}