class Solution {
    public int maxDistance(List<List<Integer>> arrays) {

        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDist = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int currentMin = array.get(0);
            int currentMax = array.get(array.size() - 1);
            maxDist = Math.max(maxDist, Math.max(Math.abs(currentMax - minVal), Math.abs(maxVal - currentMin)));

            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }
        return maxDist;
    }
}