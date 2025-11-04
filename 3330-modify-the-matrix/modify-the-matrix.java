class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int n = matrix[0].length, m = matrix.length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++)
                max = Math.max(max, matrix[j][i]);
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] == -1)
                    answer[j][i] = max;
                else
                    answer[j][i] = matrix[j][i];
            }
        }
        return answer;
    }
}