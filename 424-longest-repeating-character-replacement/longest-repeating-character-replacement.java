class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;
        int[] count = new int[26];

        while (r < s.length()) {
            count[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(r) - 'A']);

            if ((r - l + 1) - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                maxFreq = 0;
                l++;
            }
            if ((r - l + 1) - maxFreq <= k)
                maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}