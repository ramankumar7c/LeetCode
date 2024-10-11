class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Integer> emptyChairs = new PriorityQueue<>();
        PriorityQueue<int[]> occupied = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < times.length; i++)
            times[i] = new int[] { times[i][0], times[i][1], i };

        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
        int nextAvailableChair = 0;

        for (int[] time : times) {
            int arrival = time[0];
            int leaving = time[1];
            int friendIndex = time[2];

            while (!occupied.isEmpty() && occupied.peek()[0] <= arrival)
                emptyChairs.add(occupied.poll()[1]);

            if (friendIndex == targetFriend)
                return emptyChairs.isEmpty() ? nextAvailableChair : emptyChairs.peek();

            int assignedChair = emptyChairs.isEmpty() ? nextAvailableChair++ : emptyChairs.poll();
            occupied.add(new int[] { leaving, assignedChair });
        }
        throw new IllegalArgumentException("Target friend not found");
    }
}