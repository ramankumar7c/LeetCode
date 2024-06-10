class Solution {
    public boolean isPalindrome(int x) {
        int original=x;
        int remainder,reversed=0;
        if(x<0)
        return false;
        while(x!=0){
            remainder=x%10;
            reversed=reversed*10+remainder;
            x/=10;
        }
        if(reversed==original)
        return true;
        else
        return false;
    }
}