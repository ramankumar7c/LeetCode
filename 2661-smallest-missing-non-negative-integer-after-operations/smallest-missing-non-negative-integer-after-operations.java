class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];

        for (int num : nums) {
            int rem = ((num % value) + value) % value;
            freq[rem]++;
        }

        int i = 0;
        while (true) {
            int rem = i % value;
            if (freq[rem] == 0)
                return i;
            freq[rem]--;
            i++;
        }
    }
}