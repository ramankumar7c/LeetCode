class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for (int i = 1; i <= s.length(); i++) {
            char ch = s.charAt(i - 1);
            int index = 123 - ch;
            sum += (index * i);
        }
        return sum;
    }
}