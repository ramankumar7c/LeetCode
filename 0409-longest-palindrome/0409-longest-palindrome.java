class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for(int i=0;i<s.length();i++)
        count[s.charAt(i)]++;

        int ans = 0;
        for(int v:count){
            ans += v - (v&1);
            if(ans%2==0 && v%2==1)
            ans++;
        }
        return ans;
    }
}