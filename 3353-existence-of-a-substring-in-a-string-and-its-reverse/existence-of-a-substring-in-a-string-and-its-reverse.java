class Solution {
    public boolean isSubstringPresent(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();

        for (int i = 0; i < s.length() - 1; i++) {
            if (reverse.contains(s.substring(i, i + 2)))
                return true;
        }
        return false;
    }
}