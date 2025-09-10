class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        BitSet[] knows = new BitSet[m];

        for (int i = 0; i < m; i++) {
            knows[i] = new BitSet(n + 1);
            for (int lang : languages[i])
                knows[i].set(lang);
        }

        Set<Integer> needTeach = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1;
            BitSet copy = (BitSet) knows[u].clone();
            copy.and(knows[v]);
            if (copy.isEmpty()) {
                needTeach.add(u);
                needTeach.add(v);
            }
        }
        if (needTeach.isEmpty())
            return 0;

        int[] count = new int[n + 1];
        for (int u : needTeach)
            for (int lang : languages[u])
                count[lang]++;

        int maxFreq = 0;
        for (int lang = 1; lang <= n; lang++)
            maxFreq = Math.max(maxFreq, count[lang]);

        return needTeach.size() - maxFreq;
    }
}