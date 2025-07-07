class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int maxEventsAttended = 0;
        int currentDay = 1;
        int i = 0;
        int n = events.length;

        while (i < n || !minHeap.isEmpty()) {
            while (i < n && events[i][0] <= currentDay) {
                minHeap.offer(events[i][1]);
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek() < currentDay)
                minHeap.poll();

            if (!minHeap.isEmpty()) {
                minHeap.poll();
                maxEventsAttended++;
            }

            currentDay++;
        }

        return maxEventsAttended;
    }
}