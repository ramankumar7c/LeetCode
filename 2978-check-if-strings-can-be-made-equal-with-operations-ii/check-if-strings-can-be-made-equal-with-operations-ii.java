class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] evenChars = new int[26];
        int[] oddChars = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (i % 2 == 0) {
                evenChars[c - 'a']++;
            } else
                oddChars[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (i % 2 == 0) {
                if (evenChars[c - 'a'] == 0)
                    return false;
                else
                    evenChars[c - 'a']--;
            } else {
                if (oddChars[c - 'a'] == 0)
                    return false;
                else
                    oddChars[c - 'a']--;
            }
        }
        return true;
    }
}