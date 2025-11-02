class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int carry = 0;
        for (int i = num.length - 1; i >= 0 || k > 0; i--, k /= 10) {
            int sum = (i >= 0 ? num[i] : 0) + (k % 10) + carry;
            ans.add(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0)
            ans.add(carry);

        Collections.reverse(ans);
        return ans;
    }
}