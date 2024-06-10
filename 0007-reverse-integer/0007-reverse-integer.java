class Solution {
    public int reverse(int x) {
        long reversed=0;
        int remainder;

        while(x!=0){
            remainder=x%10;
            reversed=reversed*10+remainder;
            x/=10;
        }
        if(reversed<Integer.MIN_VALUE||reversed>Integer.MAX_VALUE)
        return 0;
        else
        return (int)reversed;
    }
}