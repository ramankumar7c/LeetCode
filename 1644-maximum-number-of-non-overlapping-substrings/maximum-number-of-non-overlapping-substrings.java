class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();

        int[] leftmost = new int[26];
        int[] rightmost = new int[26];

        Arrays.fill(leftmost, n);
        Arrays.fill(rightmost, -1);

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            leftmost[idx] = Math.min(leftmost[idx], i);
            rightmost[idx] = i;
        }

        int right = -1;

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';

            if (i == leftmost[idx]) {
                int newRight = rightmost[idx];
                boolean valid = true;

                for (int j = i; j <= newRight; j++) {
                    int charIdx = s.charAt(j) - 'a';

                    if (leftmost[charIdx] < i) {
                        valid = false;
                        break;
                    }

                    newRight = Math.max(newRight, rightmost[charIdx]);
                }

                if (!valid) {
                    continue;
                }

                if (i <= right && !ans.isEmpty()) {
                    ans.set(ans.size() - 1, s.substring(i, newRight + 1));
                } else {
                    ans.add(s.substring(i, newRight + 1));
                }

                right = newRight;
            }
        }

        return ans;
    }
}