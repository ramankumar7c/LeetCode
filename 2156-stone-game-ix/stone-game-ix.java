class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];

        for (int stone : stones)
            count[stone % 3]++;

        return canAliceWin(count[1], count[2], count[0]);
    }

    private boolean canAliceWin(int mod1, int mod2, int mod0) {
        if (mod0 % 2 == 0)
            return mod1 > 0 && mod2 > 0;
        else
            return Math.abs(mod1 - mod2) > 2;
    }
}