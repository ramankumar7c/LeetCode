class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];

        int last = -n;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c)
                last = i;
            answer[i] = i - last;
        }

        last = 2 * n;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c)
                last = i;
            answer[i] = Math.min(answer[i], last - i);
        }

        return answer;
    }
}