class Solution {
    public int possibleStringCount(String word) {
        int count = 1;
        int i = 1;
        while (i < word.length()) {
            if (word.charAt(i) == word.charAt(i - 1))
                count++;
            i++;
        }
        return count;
    }
}