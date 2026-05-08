class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            Set<Integer> factors = primeFactors(x);

            for (int p : factors) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        Set<Integer> usedPrime = new HashSet<>();

        q.offer(0);
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int i = q.poll();

                if (i == n - 1)
                    return steps;

                if (i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }

                if (i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }

                int val = nums[i];

                if (isPrime(val) && !usedPrime.contains(val)) {
                    usedPrime.add(val);

                    List<Integer> next = map.getOrDefault(val, new ArrayList<>());

                    for (int idx : next) {
                        if (!vis[idx]) {
                            vis[idx] = true;
                            q.offer(idx);
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean isPrime(int x) {
        if (x < 2)
            return false;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }

        return true;
    }

    private Set<Integer> primeFactors(int x) {
        Set<Integer> set = new HashSet<>();

        for (int i = 2; i * i <= x; i++) {
            while (x % i == 0) {
                set.add(i);
                x /= i;
            }
        }

        if (x > 1)
            set.add(x);

        return set;
    }
}