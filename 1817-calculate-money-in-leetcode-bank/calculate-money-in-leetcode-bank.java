class Solution {
    public int totalMoney(int n) {
        int amount = 0;
        int weekStart = 1;
        while (n > 0) {
            for (int i = 0; i < Math.min(7, n); i++)
                amount += weekStart + i;

            weekStart++;
            n -= 7;
        }
        return amount;
    }
}