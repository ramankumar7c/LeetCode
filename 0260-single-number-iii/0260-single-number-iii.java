class Solution {
    public int[] singleNumber(int[] nums) {
        int xors = 0;
        for(int num : nums)
        xors ^= num;

        int diffBit = xors & ~(xors-1);

        int[] result = new int[2];
        for(int num: nums){
            if((num & diffBit) == 0)
            result[0] ^= num;
            else
            result[1] ^= num;
        }
        return result;
    }
}