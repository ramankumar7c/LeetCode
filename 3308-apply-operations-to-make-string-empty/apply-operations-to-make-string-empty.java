class Solution {
    public String lastNonEmptyString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int maxFreq = Arrays.stream(freq).max().getAsInt();

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (freq[s.charAt(i) - 'a'] == maxFreq) {
                sb.append(s.charAt(i));
                freq[s.charAt(i) - 'a']--;
            }
        }
        return sb.reverse().toString();
    }
}