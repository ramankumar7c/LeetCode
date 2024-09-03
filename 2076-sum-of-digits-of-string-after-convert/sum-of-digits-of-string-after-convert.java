class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            int val = c - 'a' + 1;
            sum += sumDigits(val);
        }
        for (int i = 1; i < k; i++)
            sum = sumDigits(sum);

        return sum;
    }

    private int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}