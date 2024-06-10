class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = m;

        for(int i=1;i<n;i++){
            int onesCount=0;
            for(int j=0;j<m;j++)
            onesCount+=grid[j][i]==grid[j][0]?1:0;
            ans = ans*2+Math.max(onesCount,m-onesCount);
        }
        return ans;
    }
}