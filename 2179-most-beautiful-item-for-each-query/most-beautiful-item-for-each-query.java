class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];

        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        Map<Integer, Integer> priceToBeauty = new HashMap<>();
        int maxBeauty = 0;
        for (int[] item : items) {
            maxBeauty = Math.max(maxBeauty, item[1]);
            priceToBeauty.put(item[0], maxBeauty);
        }

        int[] uniquePrices = priceToBeauty.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(uniquePrices);

        int[] maxBeautyForPrices = new int[uniquePrices.length];
        for (int i = 0; i < uniquePrices.length; i++)
            maxBeautyForPrices[i] = priceToBeauty.get(uniquePrices[i]);

        for (int i = 0; i < queries.length; i++) {
            int priceIndex = Arrays.binarySearch(uniquePrices, queries[i]);
            if (priceIndex < 0)
                priceIndex = -priceIndex - 2;
            ans[i] = priceIndex >= 0 ? maxBeautyForPrices[priceIndex] : 0;
        }
        return ans;
    }
}