class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int left = 1;
        int right = position[position.length - 1] - position[0];

        while (left < right) {
            int mid = right - (right - left) / 2;
            if (numBalls(position, mid) >= m)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }

    private int numBalls(int[] position, int m) {
        int count = 0;
        int lastPosition = -m;

        for (int pos : position) {
            if (pos - lastPosition >= m) {
                count++;
                lastPosition = pos;
            }
        }
        return count;
    }
}