class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            if (matches(s1Freq, windowFreq))
                return true;

            windowFreq[s2.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i - s1.length()) - 'a']--;
        }
        return matches(s1Freq, windowFreq);
    }

    private boolean matches(int[] s1Freq, int[] windowFreq) {
        for (int i = 0; i < 26; i++)
            if (s1Freq[i] != windowFreq[i])
                return false;

        return true;
    }
}