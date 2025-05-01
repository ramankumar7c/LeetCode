class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n];
        int[] neg = new int[n];

        int p = 0, q = 0;
        for (int num : nums) {
            if (num >= 0)
                pos[p++] = num;
            else
                neg[q++] = num;
        }

        int[] arr = new int[n];

        int i = 0, j = 0, k = 0;
        while (i < p && j < q) {
            arr[k++] = pos[i++];
            arr[k++] = neg[j++];
        }

        while (i < p)
            arr[k++] = pos[i++];

        while (j < q)
            arr[k++] = pos[j++];

        return arr;
    }
}