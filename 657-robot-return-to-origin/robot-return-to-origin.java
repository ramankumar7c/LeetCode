class Solution {
    public boolean judgeCircle(String moves) {
        int countX = 0, countY = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R')
                countX++;
            else if (c == 'L')
                countX--;
            else if (c == 'U')
                countY++;
            else
                countY--;
        }
        return countX == 0 && countY == 0;
    }
}