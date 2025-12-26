class Solution {
    public int bestClosingTime(String customers) {
        int totalY = 0;
        for (char c : customers.toCharArray())
            if (c == 'Y')
                totalY++;

        int openPenalty = 0, remainingY = totalY;
        int minPenalty = remainingY;
        int bestHour = 0;

        for (int j = 1; j <= customers.length(); j++) {
            char prev = customers.charAt(j - 1);
            if (prev == 'N')
                openPenalty++;
            else
                remainingY--;

            int penalty = openPenalty + remainingY;

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = j;
            }
        }
        return bestHour;
    }
}