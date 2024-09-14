class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        boolean[] present1 = new boolean[26];
        boolean[] present2 = new boolean[26];

        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
            present1[c - 'a'] = true;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
            present2[c - 'a'] = true;
        }
        if (!Arrays.equals(present1, present2))
            return false;

        Arrays.sort(count1);
        Arrays.sort(count2);

        return Arrays.equals(count1, count2);
    }
}