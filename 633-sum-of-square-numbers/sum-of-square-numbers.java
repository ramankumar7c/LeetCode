class Solution {
    public boolean judgeSquareSum(int c) {
        HashSet<Integer> squares = new HashSet<>();
        int limit = (int) Math.sqrt(c);

        for (int i = 0; i <= limit; i++)
            squares.add(i * i);

        for (int i = 0; i <= limit; i++)
            if (squares.contains(c - i * i))
                return true;

        return false;
    }
}