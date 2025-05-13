class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1_000_000_007;
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;

        while (t-- > 0) {
            int[] newCount = new int[26];
            for (int i = 0; i < 25; i++)
                newCount[i + 1] = count[i];
            newCount[0] = count[25];
            newCount[1] = (newCount[1] + count[25]) % MOD;
            count = newCount;
        }
        int total = 0;
        for (int num : count)
            total = (total + num) % MOD;

        return total;
    }
}