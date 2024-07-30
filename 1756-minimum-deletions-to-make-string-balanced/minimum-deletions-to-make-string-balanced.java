class Solution {
    public int minimumDeletions(String s) {
        int dp = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a')
                dp = Math.min(dp + 1, count);
            else
                count++;
        }
        return dp;
    }
}