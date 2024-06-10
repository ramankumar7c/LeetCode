class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;

        for(int j=1;j<=n;j++){
            if(p.charAt(j-1)=='*')
            dp[0][j]=dp[0][j-2];
        }

        for(int i=1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(p.charAt(j-1)=='*')
                dp[i][j] = dp[i][j-2] || (matches(s,p,i-1,j-2)&&dp[i-1][j]);
                else
                dp[i][j] = matches(s,p,i-1,j-1)&&dp[i-1][j-1];
            }
        }
        return dp[m][n];
    }
    private boolean matches(String s, String p, int i, int j){
        if(i<0)
        return false;
        if(p.charAt(j)=='.')
        return true;

        return s.charAt(i)==p.charAt(j);
    }
}