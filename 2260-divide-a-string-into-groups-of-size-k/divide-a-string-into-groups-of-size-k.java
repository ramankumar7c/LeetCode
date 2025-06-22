class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int gC = (n + k - 1) / k;
        String[] ans = new String[gC];

        int index = 0;
        for (int i = 0; i < n; i += k) {
            StringBuilder group = new StringBuilder();
            for (int j = i; j < i + k; j++) {
                if (j < n)
                    group.append(s.charAt(j));
                else
                    group.append(fill);
            }
            ans[index++] = group.toString();
        }
        return ans;
    }
}