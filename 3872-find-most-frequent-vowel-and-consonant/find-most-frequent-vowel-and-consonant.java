class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        boolean[] isVowel = new boolean[26];
        for (char v : "aeiou".toCharArray())
            isVowel[v - 'a'] = true;

        int maxC = 0, maxV = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                continue;
            if (isVowel[i])
                maxV = Math.max(maxV, freq[i]);
            else
                maxC = Math.max(maxC, freq[i]);
        }
        return maxV + maxC;
    }
}