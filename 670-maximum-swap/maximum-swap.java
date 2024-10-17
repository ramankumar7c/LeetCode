class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int maxIndex = digits.length - 1;
        int iSwap = -1, jSwap = -1;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] > digits[maxIndex])
                maxIndex = i;

            else if (digits[i] < digits[maxIndex]) {
                iSwap = i;
                jSwap = maxIndex;
            }
        }
        if (iSwap != -1) {
            char temp = digits[iSwap];
            digits[iSwap] = digits[jSwap];
            digits[jSwap] = temp;
        }
        return Integer.parseInt(new String(digits));
    }
}