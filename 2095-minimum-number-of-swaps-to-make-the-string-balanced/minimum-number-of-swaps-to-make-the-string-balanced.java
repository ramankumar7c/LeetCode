class Solution {
    public int minSwaps(String s) {
        int openCount = 0, closeCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '[')
                openCount++;
            else {
                if (openCount > 0)
                    openCount--;
                else
                    closeCount++;
            }
        }
        return (closeCount + 1) / 2;
    }
}