class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                maxProd = Math.max(maxProd, product);
            }
        }
        return maxProd;
    }
}