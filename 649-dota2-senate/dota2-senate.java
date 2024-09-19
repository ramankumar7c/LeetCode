class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> qR = new LinkedList<>();
        Queue<Integer> qD = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R')
                qR.offer(i);
            else
                qD.offer(i);
        }
        while (!qR.isEmpty() && !qD.isEmpty()) {
            int indexR = qR.poll();
            int indexD = qD.poll();

            if (indexR < indexD)
                qR.offer(indexR + n);
            else
                qD.offer(indexD + n);
        }
        return qR.isEmpty() ? "Dire" : "Radiant";
    }
}