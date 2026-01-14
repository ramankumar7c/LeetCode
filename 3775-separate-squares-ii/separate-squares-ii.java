class SegmentTree {
    int n;
    int[] xs;
    int[] coveredCount;
    int[] coveredWidth;

    SegmentTree(int[] xs) {
        this.xs = xs;
        this.n = xs.length - 1;
        this.coveredCount = new int[4 * n];
        this.coveredWidth = new int[4 * n];
    }

    void add(int l, int r, int val) {
        add(0, 0, n - 1, l, r, val);
    }

    int getCoveredWidth() {
        return coveredWidth[0];
    }

    private void add(int idx, int lo, int hi, int l, int r, int val) {
        if (r <= xs[lo] || xs[hi + 1] <= l)
            return;

        if (l <= xs[lo] && xs[hi + 1] <= r) {
            coveredCount[idx] += val;
        } else {
            int mid = (lo + hi) / 2;
            add(idx * 2 + 1, lo, mid, l, r, val);
            add(idx * 2 + 2, mid + 1, hi, l, r, val);
        }

        if (coveredCount[idx] > 0) {
            coveredWidth[idx] = xs[hi + 1] - xs[lo];
        } else if (lo == hi) {
            coveredWidth[idx] = 0;
        } else {
            coveredWidth[idx] = coveredWidth[idx * 2 + 1] + coveredWidth[idx * 2 + 2];
        }
    }
}

class Solution {

    public double separateSquares(int[][] squares) {
        List<int[]> events = new ArrayList<>();
        TreeSet<Integer> xSet = new TreeSet<>();

        for (int[] s : squares) {
            int x = s[0], y = s[1], l = s[2];
            events.add(new int[] { y, 1, x, x + l });
            events.add(new int[] { y + l, -1, x, x + l });
            xSet.add(x);
            xSet.add(x + l);
        }

        events.sort(Comparator.comparingInt(a -> a[0]));

        int[] xs = xSet.stream().mapToInt(i -> i).toArray();

        long totalArea = getTotalArea(events, xs);
        double halfArea = totalArea / 2.0;

        SegmentTree tree = new SegmentTree(xs);
        long area = 0;
        int prevY = events.get(0)[0];

        for (int[] e : events) {
            int y = e[0], delta = e[1], xl = e[2], xr = e[3];
            int coveredWidth = tree.getCoveredWidth();
            long areaGain = (long) coveredWidth * (y - prevY);

            if (area + areaGain >= halfArea) {
                return prevY + (halfArea - area) / coveredWidth;
            }

            area += areaGain;
            tree.add(xl, xr, delta);
            prevY = y;
        }

        return -1; // unreachable
    }

    private long getTotalArea(List<int[]> events, int[] xs) {
        SegmentTree tree = new SegmentTree(xs);
        long area = 0;
        int prevY = events.get(0)[0];

        for (int[] e : events) {
            int y = e[0], delta = e[1], xl = e[2], xr = e[3];
            area += (long) tree.getCoveredWidth() * (y - prevY);
            tree.add(xl, xr, delta);
            prevY = y;
        }
        return area;
    }
}