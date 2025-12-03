class Solution {
    private static class SlopeKey {
        int dx, dy;

        SlopeKey(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof SlopeKey))
                return false;
            SlopeKey other = (SlopeKey) o;
            return dx == other.dx && dy == other.dy;
        }

        @Override
        public int hashCode() {
            return 31 * dx + dy;
        }
    }

    private static class LineKey {
        int dx, dy;
        long k;

        LineKey(int dx, int dy, long k) {
            this.dx = dx;
            this.dy = dy;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof LineKey))
                return false;
            LineKey other = (LineKey) o;
            return dx == other.dx && dy == other.dy && k == other.k;
        }

        @Override
        public int hashCode() {
            int h = 31 * dx + dy;
            h = 31 * h + (int) (k ^ (k >>> 32));
            return h;
        }
    }

    private static class MidKey {
        long sx, sy;

        MidKey(long sx, long sy) {
            this.sx = sx;
            this.sy = sy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof MidKey))
                return false;
            MidKey other = (MidKey) o;
            return sx == other.sx && sy == other.sy;
        }

        @Override
        public int hashCode() {
            int h = (int) (sx ^ (sx >>> 32));
            h = 31 * h + (int) (sy ^ (sy >>> 32));
            return h;
        }
    }

    private static class SlopeInfo {
        long segmentCount = 0;
        Map<Integer, Integer> deg = new HashMap<>();
    }

    private static class LineData {
        SlopeKey slope;
        Set<Integer> points = new HashSet<>();

        LineData(SlopeKey slope) {
            this.slope = slope;
        }
    }

    private static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private static SlopeKey normalizeSlope(int dx, int dy) {
        if (dx == 0 && dy == 0)
            return new SlopeKey(0, 0);
        long g = gcd(dx, dy);
        dx /= g;
        dy /= g;
        if (dx < 0 || (dx == 0 && dy < 0)) {
            dx = -dx;
            dy = -dy;
        }
        return new SlopeKey(dx, dy);
    }

    public int countTrapezoids(int[][] points) {
        int n = points.length;
        if (n < 4)
            return 0;

        int[] xs = new int[n];
        int[] ys = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = points[i][0];
            ys[i] = points[i][1];
        }

        Map<SlopeKey, SlopeInfo> slopeMap = new HashMap<>();
        Map<LineKey, LineData> lineMap = new HashMap<>();
        Map<MidKey, Long> midMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dxRaw = xs[j] - xs[i];
                int dyRaw = ys[j] - ys[i];

                if (dxRaw == 0 && dyRaw == 0) {
                    continue;
                }

                SlopeKey sk = normalizeSlope(dxRaw, dyRaw);

                SlopeInfo si = slopeMap.get(sk);
                if (si == null) {
                    si = new SlopeInfo();
                    slopeMap.put(sk, si);
                }
                si.segmentCount++;
                si.deg.put(i, si.deg.getOrDefault(i, 0) + 1);
                si.deg.put(j, si.deg.getOrDefault(j, 0) + 1);

                long k = (long) sk.dx * ys[i] - (long) sk.dy * xs[i];
                LineKey lk = new LineKey(sk.dx, sk.dy, k);
                LineData ld = lineMap.get(lk);
                if (ld == null) {
                    ld = new LineData(sk);
                    lineMap.put(lk, ld);
                }
                ld.points.add(i);
                ld.points.add(j);

                long sx = (long) xs[i] + xs[j];
                long sy = (long) ys[i] + ys[j];
                MidKey mk = new MidKey(sx, sy);
                midMap.put(mk, midMap.getOrDefault(mk, 0L) + 1);
            }
        }

        long totalPairs = 0;
        long sharedEndpointPairs = 0;

        for (SlopeInfo si : slopeMap.values()) {
            long m = si.segmentCount;
            if (m >= 2) {
                totalPairs += m * (m - 1) / 2;
            }
            for (int cnt : si.deg.values()) {
                if (cnt >= 2) {
                    sharedEndpointPairs += (long) cnt * (cnt - 1) / 2;
                }
            }
        }

        long sameLineDisjointPairs = 0;
        for (LineData ld : lineMap.values()) {
            int s = ld.points.size();
            if (s >= 4) {
                long sl = s;
                sameLineDisjointPairs += 3L * (sl * (sl - 1) * (sl - 2) * (sl - 3) / 24L);
            }
        }

        long validParallelPairs = totalPairs - sharedEndpointPairs - sameLineDisjointPairs;

        long totalParallelograms = 0;
        for (long c : midMap.values()) {
            if (c >= 2) {
                totalParallelograms += c * (c - 1) / 2;
            }
        }

        long degenerateParallelograms = 0;
        for (LineData ld : lineMap.values()) {
            int s = ld.points.size();
            if (s < 4)
                continue;

            List<Integer> pts = new ArrayList<>(ld.points);
            Map<MidKey, Long> localMid = new HashMap<>();

            for (int i = 0; i < s; i++) {
                int a = pts.get(i);
                for (int j = i + 1; j < s; j++) {
                    int b = pts.get(j);
                    long sx = (long) xs[a] + xs[b];
                    long sy = (long) ys[a] + ys[b];
                    MidKey mk = new MidKey(sx, sy);
                    localMid.put(mk, localMid.getOrDefault(mk, 0L) + 1);
                }
            }
            for (long c : localMid.values()) {
                if (c >= 2) {
                    degenerateParallelograms += c * (c - 1) / 2;
                }
            }
        }

        long nonDegenerateParallelograms = totalParallelograms - degenerateParallelograms;

        return (int) (validParallelPairs - nonDegenerateParallelograms);
    }
}