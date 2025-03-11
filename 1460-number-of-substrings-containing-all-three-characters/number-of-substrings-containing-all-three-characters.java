class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int[] lastSeen = { -1, -1, -1 };

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a')
                lastSeen[0] = i;
            else if (c == 'b')
                lastSeen[1] = i;
            else if (c == 'c')
                lastSeen[2] = i;

            int minLastSeen = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            if (minLastSeen != -1)
                ans += minLastSeen + 1;
        }
        return ans;
    }
}