class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int sum = 0;
        int prev = -1;
        for (int i = 0; i < gas.length; i++) {
            total = total + gas[i] - cost[i];
            if (sum + gas[i] - cost[i] < 0) {
                sum = 0;
                prev = -1;
            } else {
                if (prev == -1) {
                    prev = i;
                } 
                sum = sum + gas[i] - cost[i];
            }
        }
        if (total < 0) {
            return -1;
        }
        return prev;
    }
}
