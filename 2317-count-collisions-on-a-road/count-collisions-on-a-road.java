class Solution {
    public int countCollisions(String directions) {
        int l = 0, r = directions.length() - 1;

        while (l < directions.length() && directions.charAt(l) == 'L')
            l++;

        while (r >= 0 && directions.charAt(r) == 'R')
            r--;

        int ans = 0;
        for (int i = l; i <= r; i++)
            if (directions.charAt(i) != 'S')
                ans++;

        return ans;
    }
}