class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        Map<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0) {
                ans[i] = -1;

                if (lastRain.containsKey(lake)) {
                    Integer dryDay = dryDays.higher(lastRain.get(lake));
                    if (dryDay == null)
                        return new int[0];
                    ans[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                lastRain.put(lake, i);
            } else
                dryDays.add(i);
        }
        return ans;
    }
}