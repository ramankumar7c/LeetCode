class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1])
                return a[1] - b[1];
            return b[0] - a[0];
        });

        int p1 = -1;
        int p2 = -1;
        int count = 0;

        for (int[] in : intervals) {
            int L = in[0], R = in[1];

            boolean hasP1 = (p1 >= L && p1 <= R);
            boolean hasP2 = (p2 >= L && p2 <= R);

            if (hasP1 && hasP2)
                continue;

            if (hasP1 || hasP2) {
                count++;

                if (p1 < L || p1 > R) {
                    p2 = p1;
                    p1 = R;
                } else {
                    p2 = p1;
                    p1 = R;
                }
            } else {
                count += 2;
                p2 = R - 1;
                p1 = R;
            }
        }
        return count;
    }
}