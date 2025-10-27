class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0, prev = 0;
        for (String row : bank) {
            int ones = 0;
            for (char c : row.toCharArray())
                if (c == '1')
                    ones++;

            if (ones > 0) {
                ans += prev * ones;
                prev = ones;
            }
        }
        return ans;
    }
}