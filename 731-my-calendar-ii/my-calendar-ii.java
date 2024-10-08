class MyCalendarTwo {

    private List<int[]> bookings;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] overlap : overlaps)
            if (start < overlap[1] && end > overlap[0])
                return false;

        for (int[] booking : bookings)
            if (start < booking[1] && end > booking[0])
                overlaps.add(new int[] { Math.max(start, booking[0]), Math.min(end, booking[1]) });

        bookings.add(new int[] { start, end });
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */