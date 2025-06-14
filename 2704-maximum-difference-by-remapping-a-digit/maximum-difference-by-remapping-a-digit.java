class Solution {
    public int minMaxDifference(int num) {
        String numStr = Integer.toString(num);
        int max = num, min = num;

        for (char from = '0'; from <= '9'; from++) {
            for (char to = '0'; to <= '9'; to++) {
                String replaced = numStr.replace(from, to);

                int newNum = Integer.parseInt(replaced);
                max = Math.max(max, newNum);
                min = Math.min(min, newNum);
            }
        }
        return max - min;
    }
}