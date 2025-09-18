class TaskManager {
    private static class Task {
        int userId, taskId, priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private Map<Integer, Task> taskMap = new HashMap<>();
    private PriorityQueue<Task> pq;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority)
                return Integer.compare(b.priority, a.priority);
            return Integer.compare(b.taskId, a.taskId);
        });
        for (List<Integer> t : tasks)
            add(t.get(0), t.get(1), t.get(2));
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        pq.offer(task);
    }

    public void edit(int taskId, int newPriority) {
        Task old = taskMap.get(taskId);
        if (old == null)
            return;
        Task updated = new Task(old.userId, taskId, newPriority);
        taskMap.put(taskId, updated);
        pq.offer(updated);
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Task top = pq.poll();
            Task curr = taskMap.get(top.taskId);
            if (curr == top) {
                taskMap.remove(top.taskId);
                return top.userId;
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */