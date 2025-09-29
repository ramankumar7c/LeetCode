class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiag = 0;
        int maxArea = 0;

        for (int[] d : dimensions) {
            double diag = Math.sqrt(d[0] * d[0] + d[1] * d[1]);
            int area = d[0] * d[1];

            if (diag > maxDiag || (diag == maxDiag && area > maxArea)) {
                maxDiag = diag;
                maxArea = area;
            }
        }
        return maxArea;
    }
}