class Solution {
    public int smallestRangeII(int[] nums, int k) {
        if(nums.length==1)
        return 0;

        Arrays.sort(nums);

        int initialRange = nums[nums.length-1]-nums[0];
        int minRange = initialRange;

        for(int i=0;i<nums.length-1;i++){
            int high = Math.max(nums[nums.length-1]-k,nums[i]+k);
            int low = Math.min(nums[0]+k,nums[i+1]-k);
            minRange = Math.min(minRange,high-low);
        }
        return minRange;
    }
}