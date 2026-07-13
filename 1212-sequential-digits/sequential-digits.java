class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String number = "123456789";
        List<Integer> ans = new ArrayList<>();

        for (int len = 2; len <= 9; len++) {
            for (int i = 0; i + len <= 9; i++) {
                int num = Integer.parseInt(number.substring(i, i + len));

                if (num >= low && num <= high)
                    ans.add(num);
            }
        }
        return ans;
    }
}