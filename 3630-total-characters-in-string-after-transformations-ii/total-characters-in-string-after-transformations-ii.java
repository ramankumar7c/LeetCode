class Solution {
    private static int MOD = 1_000_000_007;
    
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[][] T = getTransformationMatrix(nums);
        int[][] poweredT = matrixPow(T, t);
        int[] count = new int[26];
        long[] lengths = new long[26];

        for (char c : s.toCharArray())
            count[c - 'a']++;

        for (int i = 0; i < 26; i++)
            for (int j = 0; j < 26; j++) {
                lengths[j] += (long) count[i] * poweredT[i][j];
                lengths[j] %= MOD;
            }

        return (int) (Arrays.stream(lengths).sum() % MOD);
    }

    private int[][] getTransformationMatrix(List<Integer> nums) {
        int[][] T = new int[26][26];
        for (int i = 0; i < nums.size(); i++)
            for (int step = 1; step <= nums.get(i); step++)
                T[i][(i + step) % 26]++;
        return T;
    }

    private int[][] matrixPow(int[][] M, int pow) {
        int[][] result = new int[26][26];
        for (int i = 0; i < 26; i++) result[i][i] = 1;
        
        while (pow > 0) {
            if (pow % 2 == 1)
                result = matrixMult(result, M);
            M = matrixMult(M, M);
            pow /= 2;
        }
        return result;
    }

    private int[][] matrixMult(int[][] A, int[][] B) {
        int[][] C = new int[26][26];
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < 26; j++)
                for (int k = 0; k < 26; k++)
                    C[i][j] = (int)((C[i][j] + (long)A[i][k] * B[k][j]) % MOD);
        return C;
    }
}