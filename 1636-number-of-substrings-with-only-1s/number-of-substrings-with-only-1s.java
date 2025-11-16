class Solution {
    public int numSub(String s) {
        int kMod = 1000000007;

        int ans = 0, l = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                l = i;
            }
            ans = (ans + i - l) % kMod;
        }
        return ans;
    }
}