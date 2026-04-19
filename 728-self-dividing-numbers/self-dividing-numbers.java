class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (dividing(num))
                ans.add(num);
        }
        return ans;
    }

    private boolean dividing(int num) {
        for (int n = num; n > 0; n /= 10) {
            if (n % 10 == 0 || num % (n % 10) != 0)
                return false;
        }
        return true;
    }
}