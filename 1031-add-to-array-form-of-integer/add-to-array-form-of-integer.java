class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num.length - 1; i >= 0 || k > 0; i--, k /= 10) {
            int sum = (i >= 0 ? num[i] : 0) + (k % 10) + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0)
            sb.append(carry);

        sb.reverse();

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++) {
            ans.add(sb.charAt(i) - '0');
        }
        return ans;
    }
}