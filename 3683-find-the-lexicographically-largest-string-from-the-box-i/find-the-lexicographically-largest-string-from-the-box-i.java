class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1)
            return word;

        int start = findLexLargestStartIndex(word);
        int maxLength = word.length() - numFriends + 1;

        return word.substring(start, Math.min(word.length(), start + maxLength));
    }

    private int findLexLargestStartIndex(String s) {
        int n = s.length();
        int i = 0, j = 1, k = 0;

        while (j + k < n) {
            if (s.charAt(i + k) == s.charAt(j + k))
                k++;
            else if (s.charAt(i + k) > s.charAt(j + k)) {
                j = j + k + 1;
                k = 0;
            } else {
                i = Math.max(i + k + 1, j);
                j = i + 1;
                k = 0;
            }
        }
        return i;
    }
}