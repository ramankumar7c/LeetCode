class Solution {
    public int maxDistance(String s, int k) {
        return Math.max(Math.max(flip(s, k, "NE"), flip(s, k, "NW")), Math.max(flip(s, k, "SE"), flip(s, k, "SW")));
    }

    private int flip(String s, int k, String dir) {
        int res = 0, pos = 0, opposite = 0;

        for (char c : s.toCharArray()) {
            if (dir.indexOf(c) >= 0)
                pos++;
            else {
                pos--;
                opposite++;
            }
            res = Math.max(res, pos + 2 * Math.min(k, opposite));
        }
        return res;
    }
}