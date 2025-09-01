class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(b[0], a[0]));

        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            maxHeap.offer(new double[] { getExtraPassRatio(pass, total), pass, total });
        }

        while (extraStudents-- > 0) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1] + 1;
            int total = (int) top[2] + 1;
            maxHeap.offer(new double[] { getExtraPassRatio(pass, total), pass, total });
        }

        double sum = 0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            sum += top[1] / top[2];
        }

        return sum / classes.length;
    }

    private double getExtraPassRatio(int pass, int total) {
        return (pass + 1.0) / (total + 1) - pass * 1.0 / total;
    }
}