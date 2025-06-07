class Solution {
    public String clearStars(String s) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            else
                return b[1] - a[1];
        });

        boolean[] removed = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (!heap.isEmpty()) {
                    int[] entry = heap.poll();
                    removed[entry[1]] = true;
                }
                removed[i] = true;
            } else
                heap.offer(new int[] { c - 'a', i });
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            if (!removed[i])
                sb.append(s.charAt(i));

        return sb.toString();
    }
}