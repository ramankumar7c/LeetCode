class Solution {
    public int minChanges(String s) {
        int ans = 0;
        int n = s.length();

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1))
                ans++;

            i++;
        }
        return ans;
    }
}