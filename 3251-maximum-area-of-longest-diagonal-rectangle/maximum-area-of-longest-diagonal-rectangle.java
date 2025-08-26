class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiag = 0, maxArea = 0;

        for (int[] d : dimensions) {
            int diag = d[0] * d[0] + d[1] * d[1];
            int area = d[0] * d[1];

            if (diag > maxDiag || (diag == maxDiag && area > maxArea)) {
                maxDiag = diag;
                maxArea = area;
            }
        }

        return maxArea;
    }
}