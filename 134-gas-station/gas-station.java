class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr_Gas = 0, total_Gas = 0, startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int netGas = gas[i] - cost[i];
            curr_Gas += netGas;
            total_Gas += netGas;

            if (curr_Gas < 0) {
                startStation = i + 1;
                curr_Gas = 0;
            }
        }
        return total_Gas >= 0 ? startStation : -1;
    }
}