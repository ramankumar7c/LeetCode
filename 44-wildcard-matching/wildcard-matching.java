class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0, starIdx = -1, matchIdx = 0;

        while(sIdx < s.length()){
            if(pIdx < p.length() && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))){
                sIdx++;
                pIdx++;
            }
            else if(pIdx < p.length() && p.charAt(pIdx) == '*'){
                starIdx = pIdx;
                matchIdx = sIdx;
                pIdx++;
            }
            else if(starIdx != -1){
                pIdx = starIdx + 1;
                matchIdx++;
                sIdx = matchIdx;
            }
            else
                return false;
        }
        while(pIdx < p.length() && p.charAt(pIdx) == '*')
            pIdx++;

        return pIdx == p.length();
    }
}