class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(k==0){
            for(int i = 0;i<nums.length-1;i++){
                if(nums[i]==0&&nums[i+1]==0)
                return true;
            }
            return false;
        }
        Map<Integer,Integer>remainderToIndex = new HashMap<>();
        remainderToIndex.put(0,-1);
        int runningSum=0;

        for(int i=0;i<nums.length;i++){
            runningSum+=nums[i];
            int remainder = runningSum%k;

            if(remainderToIndex.containsKey(remainder)){
                if(i-remainderToIndex.get(remainder)>1)
                return true;
            }
            else
            remainderToIndex.put(remainder,i);
        }
        return false;
    }
}