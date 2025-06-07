class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1;
        int maxL = height[l], maxR = height[r];

        while (l < r) {
            if (maxL < maxR) {
                ans += maxL - height[l];
                maxL = Math.max(maxL, height[++l]);
            } else {
                ans += maxR - height[r];
                maxR = Math.max(maxR, height[--r]);
            }
        }
        return ans;
    }
}