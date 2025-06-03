class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int ans = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] hasBox = new boolean[status.length];
        boolean[] hasKey = new boolean[status.length];

        for (int box : initialBoxes) {
            if (status[box] == 1)
                queue.offer(box);
            else
                hasBox[box] = true;
        }

        while (!queue.isEmpty()) {
            int currentBox = queue.poll();
            ans += candies[currentBox];

            for (int key : keys[currentBox]) {
                hasKey[key] = true;
                if (hasBox[key]) {
                    queue.offer(key);
                    hasBox[key] = false;
                }
            }

            for (int box : containedBoxes[currentBox]) {
                if (status[box] == 1)
                    queue.offer(box);
                else {
                    hasBox[box] = true;
                    if (hasKey[box]) {
                        queue.offer(box);
                        hasBox[box] = false;
                    }
                }
            }
        }

        return ans;
    }
}