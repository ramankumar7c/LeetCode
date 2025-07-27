class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int top = 0, bottom = mat.length - 1;

        while (top < bottom) {
            int mid = (top + bottom) / 2;
            int maxCol = getMaxIndex(mat[mid]);
            if (mat[mid][maxCol] >= mat[mid + 1][maxCol])
                bottom = mid;
            else
                top = mid + 1;
        }
        return new int[] { top, getMaxIndex(mat[top]) };
    }

    private int getMaxIndex(int[] row) {
        int maxIndex = 0;
        for (int i = 1; i < row.length; i++)
            if (row[i] > row[maxIndex])
                maxIndex = i;

        return maxIndex;
    }
}