class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int l = 0, r = 0, minLen = Integer.MAX_VALUE, sIndex = 0, count = 0;
        int[] need = new int[256];
        for (char c : t.toCharArray())
            need[c]++;

        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0)
                count++;
            need[c]--;
            r++;

            while (count == m) {
                if (r - l < minLen) {
                    minLen = r - l;
                    sIndex = l;
                }
                char leftChar = s.charAt(l);
                need[leftChar]++;
                if (need[leftChar] > 0)
                    count--;
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(sIndex, sIndex + minLen);
    }
}