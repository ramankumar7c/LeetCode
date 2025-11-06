class Solution {
    public int countAsterisks(String s) {
        boolean isBar = false;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '|')
                isBar = !isBar;
            else if (c == '*' && !isBar)
                count++;
        }
        return count;
    }
}