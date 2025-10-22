class Solution {
    public int countBinarySubstrings(String s) {
        int prevGrp = 0, currGrp = 1;
        int ans = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                currGrp++;
            else {
                ans += Math.min(prevGrp, currGrp);
                prevGrp = currGrp;
                currGrp = 1;
            }
        }
        ans += Math.min(prevGrp, currGrp);
        return ans;
    }
}