class Solution {
    public double angleClock(int hour, int minutes) {
        double hourDeg = hour * 30 + minutes * 0.5;
        double minDeg = minutes * 6;

        double diff = Math.abs(hourDeg - minDeg);
        return Math.min(diff, 360 - diff);
    }
}