class Solution {
    public int findTheLongestSubstring(String s) {
        String kVowels = "aeiou";
        int ans = 0;
        int prefix = 0;
        int[] prefixFirstOccurrence = new int[1 << 5];
        Arrays.fill(prefixFirstOccurrence, -1);
        prefixFirstOccurrence[0] = 0;

        for (int i = 0; i < s.length(); i++) {
            int index = kVowels.indexOf(s.charAt(i));
            if (index != -1)
                prefix ^= 1 << index;

            if (prefixFirstOccurrence[prefix] != -1)
                ans = Math.max(ans, i + 1 - prefixFirstOccurrence[prefix]);
            else
                prefixFirstOccurrence[prefix] = i + 1;
        }
        return ans;
    }
}