class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        int[] freq = new int[26];
        int maxFreq = 0;

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            maxFreq = Math.max(maxFreq, freq[c - 'a']);
        }

        if (maxFreq > (n + 1) / 2)
            return "";

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < 26; i++)
            if (freq[i] > 0)
                pq.offer(new int[] { i, freq[i] });

        StringBuilder ans = new StringBuilder();
        int[] prev = null;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            ans.append((char) (curr[0] + 'a'));
            curr[1]--;

            if (prev != null && prev[1] > 0)
                pq.offer(prev);

            prev = curr;
        }
        return ans.length() == n ? ans.toString() : "";
    }
}