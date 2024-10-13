class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int minRangeStart = 0;
        int minRangeEnd = Integer.MAX_VALUE;

        int currentMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i).get(0);
            minHeap.offer(new int[] { num, i, 0 });
            currentMax = Math.max(currentMax, num);
        }
        while (minHeap.size() == nums.size()) {
            int[] current = minHeap.poll();
            int currentMin = current[0];
            int listIndex = current[1];
            int elementIndex = current[2];

            if (currentMax - currentMin < minRangeEnd - minRangeStart) {
                minRangeStart = currentMin;
                minRangeEnd = currentMax;
            }
            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextNum = nums.get(listIndex).get(elementIndex + 1);
                minHeap.offer(new int[] { nextNum, listIndex, elementIndex + 1 });
                currentMax = Math.max(currentMax, nextNum);
            }
        }
        return new int[] { minRangeStart, minRangeEnd };
    }
}