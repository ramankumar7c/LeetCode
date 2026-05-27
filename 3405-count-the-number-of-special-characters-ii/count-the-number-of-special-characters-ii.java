class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c))
                lower[c - 'a'] = !upper[c - 'a'];
            else
                upper[c - 'A'] = true;
        }

        int ans = 0;

        for (int i = 0; i < 26; i++)
            if (lower[i] && upper[i])
                ans++;

        return ans;
    }
}