class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        for (char c : t.toCharArray()) {
            if (freq[c - 'a'] == 0)
                return c;
            freq[c - 'a']--;
        }
        throw new IllegalArgumentException();
    }
}