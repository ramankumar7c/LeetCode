class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            ans.add(generateRow(i));
        }
        return ans;
    }

    private List<Integer> generateRow(int row) {
        List<Integer> ansRow = new ArrayList<>();
        int ans = 1;
        ansRow.add(ans);
        for (int i = 1; i < row; i++) {
            ans = ans * (row - i);
            ans = ans / i;
            ansRow.add(ans);
        }
        return ansRow;
    }
}