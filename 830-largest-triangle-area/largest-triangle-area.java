class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            int[] A = points[i];
            for (int j = 0; j < n; j++) {
                int[] B = points[j];
                for (int k = 0; k < n; k++) {
                    int[] C = points[k];
                    double area = 0.5 * Math.abs((B[0] - A[0]) * (C[1] - A[1]) - (C[0] - A[0]) * (B[1] - A[1]));
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}