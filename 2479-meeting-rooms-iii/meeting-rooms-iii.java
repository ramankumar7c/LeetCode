class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        Queue<Room> occupied = new PriorityQueue<>((a, b) -> {
            if (a.endTime != b.endTime)
                return Long.compare(a.endTime, b.endTime);

            return Integer.compare(a.roomId, b.roomId);
        });

        Queue<Integer> available = new PriorityQueue<>();

        for (int i = 0; i < n; i++)
            available.offer(i);

        int[] bookings = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;

            while (!occupied.isEmpty() && occupied.peek().endTime <= start) {
                Room freedRoom = occupied.poll();
                available.offer(freedRoom.roomId);
            }

            if (available.isEmpty()) {
                Room earliestEnding = occupied.poll();
                bookings[earliestEnding.roomId]++;
                occupied.offer(new Room(earliestEnding.endTime + duration, earliestEnding.roomId));
            } else {
                int roomId = available.poll();
                bookings[roomId]++;
                occupied.offer(new Room(end, roomId));
            }
        }

        int maxBookedRoom = 0;
        for (int i = 1; i < n; i++)
            if (bookings[i] > bookings[maxBookedRoom])
                maxBookedRoom = i;

        return maxBookedRoom;
    }

    static class Room {
        long endTime;
        int roomId;

        Room(long endTime, int roomId) {
            this.endTime = endTime;
            this.roomId = roomId;
        }
    }
}