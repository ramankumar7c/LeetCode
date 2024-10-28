class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums)
            uniqueNums.add(num);

        List<Integer> sortedNums = new ArrayList<>(uniqueNums);
        Collections.sort(sortedNums, Collections.reverseOrder());

        int maxNum = Collections.max(sortedNums);

        int[] dp = new int[maxNum + 1];

        for (int num : sortedNums) {
            dp[num] = 1;
            long squaredNum = (long) num * num;
            if (squaredNum <= maxNum)
                dp[num] += dp[(int) squaredNum];
        }
        int ans = Arrays.stream(dp).max().orElse(-1);
        return ans < 2 ? -1 : ans;
    }
}