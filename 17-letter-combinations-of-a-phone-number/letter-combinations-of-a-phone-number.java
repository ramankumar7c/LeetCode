class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty())
            return ans;

        String[] digitToLetters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        backtrack(ans, digits, digitToLetters, new StringBuilder(), 0);
        return ans;
    }

    private void backtrack(List<String> ans, String digits, String[] digitToLetters, StringBuilder current, int index) {
        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }
        String letters = digitToLetters[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(ans, digits, digitToLetters, current, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}