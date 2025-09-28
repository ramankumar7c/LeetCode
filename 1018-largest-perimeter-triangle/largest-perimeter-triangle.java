class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--)
            if (nums[i - 2] + nums[i - 1] > nums[i])
                return nums[i] + nums[i - 1] + nums[i - 2];
        
        return 0;
    }
}

// class Solution {
//     public int largestPerimeter(int[] nums) {
//         int n=nums.length;
//         if(n<3)
//         return 0;
        
//         Arrays.sort(nums);
//         int ans=0;

//         for(int k=n-1;k>=2;k--){
//             int i=0,j=k-1;
//             while(i<j){
//                 int perimeter=0;
//                 if(nums[i]+nums[j]>nums[k]){
//                     perimeter=nums[i]+nums[j]+nums[k];
//                     j--;
//                 }
//                 else
//                     i++;
//                 ans=Math.max(ans,perimeter);
//             }
//         }
//         return ans;
//     }
// }