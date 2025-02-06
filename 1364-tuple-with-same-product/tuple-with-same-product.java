class Solution {
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int prod = nums[i]*nums[j];
                count.put(prod, count.getOrDefault(prod, 0)+1);
            }
        }
        for(int freq:count.values())
            if(freq>1)
                ans+=(freq*(freq-1)/2*8);

        return ans;
    }
}