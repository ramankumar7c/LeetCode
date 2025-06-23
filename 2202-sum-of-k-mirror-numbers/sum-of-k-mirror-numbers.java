class Solution {
    public long kMirror(int k, int n) {
        long ans = 0;
        List<Character> A = new ArrayList<>();
        A.add('0');

        for (int i = 0; i < n; i++) {
            while (true) {
                A = nextKMirror(A, k);
                long num = Long.parseLong(listToString(A), k);
                if (isDecimalPalindrome(num)) {
                    ans += num;
                    break;
                }
            }
        }

        return ans;
    }

    private List<Character> nextKMirror(List<Character> A, int k) {
        int len = A.size();
        for (int i = len / 2; i < len; i++) {
            int nextNum = Character.digit(A.get(i), k) + 1;
            if (nextNum < k) {
                char c = Character.forDigit(nextNum, k);
                A.set(i, c);
                A.set(len - 1 - i, c);
                for (int j = len / 2; j < i; j++) {
                    A.set(j, '0');
                    A.set(len - 1 - j, '0');
                }
                return A;
            }
        }
        List<Character> newA = new ArrayList<>();
        newA.add('1');
        for (int i = 0; i < len - 1; i++)
            newA.add('0');

        newA.add('1');
        return newA;
    }

    private String listToString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (char c : list)
            sb.append(c);

        return sb.toString();
    }

    private boolean isDecimalPalindrome(long num) {
        String s = Long.toString(num);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }
        return true;
    }
}