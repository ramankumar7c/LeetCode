class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastSeen = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastSeen != -1 && i - lastSeen - 1 < k) {
                    return false;
                }
                lastSeen = i;
            }
        }
        return true;
    }
}