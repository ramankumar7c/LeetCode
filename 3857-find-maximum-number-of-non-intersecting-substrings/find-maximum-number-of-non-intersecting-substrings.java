class Solution {
    public int maxSubstrings(String s) {
        int n = s.length();
        List<int[]> intervals = new ArrayList<>();

        List<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++)
            pos[i] = new ArrayList<>();

        for (int i = 0; i < n; i++)
            pos[s.charAt(i) - 'a'].add(i);

        for (int c = 0; c < 26; c++) {
            List<Integer> p = pos[c];
            for (int i = 0; i < p.size(); i++) {
                int start = p.get(i);
                for (int j = i + 1; j < p.size(); j++) {
                    int end = p.get(j);
                    if (end - start + 1 >= 4) {
                        intervals.add(new int[] { start, end });
                        break;
                    }
                }
            }
        }

        intervals.sort(Comparator.comparingInt(a -> a[1]));

        int count = 0, lastEnd = -1;
        for (int[] in : intervals) {
            if (in[0] > lastEnd) {
                count++;
                lastEnd = in[1];
            }
        }
        return count;
    }
}