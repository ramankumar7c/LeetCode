class T {
    public int pro;
    public int cap;

    public T(int pro, int cap) {
        this.pro = pro;
        this.cap = cap;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<T> projects = new ArrayList<>();
        for (int i = 0; i < profits.length; i++)
            projects.add(new T(profits[i], capital[i]));

        projects.sort(Comparator.comparingInt(p -> p.cap));

        int index = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            while (index < projects.size() && projects.get(index).cap <= w) {
                maxHeap.offer(projects.get(index).pro);
                index++;
            }
            if (maxHeap.isEmpty())
                break;

            w += maxHeap.poll();
        }
        return w;
    }
}