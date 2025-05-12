class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == j || j == k || i == k)
                        continue;
                    int a = digits[i];
                    int b = digits[j];
                    int c = digits[k];
                    if (a != 0 && c % 2 == 0) {
                        int number = a * 100 + b * 10 + c;
                        result.add(number);
                    }
                }
            }
        }
        List<Integer> sortedList = new ArrayList<>(result);
        sortedList.sort(null);

        int[] ans = new int[sortedList.size()];
        for (int i = 0; i < sortedList.size(); i++)
            ans[i] = sortedList.get(i);

        return ans;
    }
}