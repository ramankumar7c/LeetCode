class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] target = sortedDigits(n);

        for (int i = 0; i < 30; i++)
            if (Arrays.equals(target, sortedDigits(1 << i)))
                return true;

        return false;
    }

    private char[] sortedDigits(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);

        return arr;
    }
}