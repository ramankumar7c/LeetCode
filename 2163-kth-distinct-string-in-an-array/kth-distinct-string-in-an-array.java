class Solution {
    public String kthDistinct(String[] arr, int k) {
        int n = arr.length;
        String[] distinct = new String[n];
        int distinctIndex = 0;

        for (int i = 0; i < n; i++) {
            boolean isDistinct = true;

            for (int j = 0; j < distinctIndex; j++) {
                if (arr[i].equals(distinct[j])) {
                    isDistinct = false;
                    break;
                }
            }
            if (isDistinct) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[i].equals(arr[j]))
                        count++;
                }
                if (count == 1)
                    distinct[distinctIndex++] = arr[i];
            }
        }
        if (k > 0 && k <= distinctIndex)
            return distinct[k - 1];
        else
            return "";
    }
}