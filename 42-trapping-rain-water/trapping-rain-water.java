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

// TC = O(3N) SC = O(2N)
// class Solution {
//     public int trap(int[] height) {
//         int n = height.length;

//         int[] prefixMax = new int[n];
//         int[] suffixMax = new int[n];

//         prefixMax[0] = height[0];
//         for (int i = 1; i < n; i++)
//             prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);

//         suffixMax[n - 1] = height[n - 1];
//         for (int i = n - 2; i >= 0; i--)
//             suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);

//         int total = 0;

//         for (int i = 0; i < n; i++) {
//             if (height[i] < prefixMax[i] && height[i] < suffixMax[i])
//                 total += Math.min(prefixMax[i], suffixMax[i]) - height[i];
//         }

//         return total;
//     }
// }