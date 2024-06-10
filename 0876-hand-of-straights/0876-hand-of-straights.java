class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int card : hand)
            minHeap.add(card);

        while (!minHeap.isEmpty()) {
            int firstCard = minHeap.poll();

            for (int i = 1; i < groupSize; i++) {
                if (!minHeap.remove(firstCard + i))
                    return false;
            }
        }
        return true;
    }
}