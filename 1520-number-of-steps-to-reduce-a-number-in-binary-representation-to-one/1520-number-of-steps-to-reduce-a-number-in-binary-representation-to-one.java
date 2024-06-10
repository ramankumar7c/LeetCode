import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {
        int ans = 0;
        BigInteger num = new BigInteger(s, 2);

        while (!num.equals(BigInteger.ONE)) {
            if (num.mod(BigInteger.TWO).equals(BigInteger.ZERO))
                num = num.divide(BigInteger.TWO);
            else
                num = num.add(BigInteger.ONE);

            ans++;
        }
        return ans;
    }
}