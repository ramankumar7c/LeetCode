class Solution {
    public boolean isValid(String word) {
        char[] c = word.toCharArray();
        boolean vowel = false, consonant = false;
        if (c.length < 3)
            return false;
            
        for (char ch : c) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }

        for (char ch : c) {
            if ("aeiouAEIOU".indexOf(ch) != -1) {
                vowel = true;
                break;
            }
        }

        for (char ch : c) {
            char lower = Character.toLowerCase(ch);
            if (Character.isLetter(ch) && "aeiou".indexOf(lower) == -1) {
                consonant = true;
            }
        }

        return (vowel && consonant);
    }
}