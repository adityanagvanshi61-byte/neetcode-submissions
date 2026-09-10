class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentTank=0;
        int totalGas=0;
        int totalCost=0;
        int startStation=0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentTank += gas[i] - cost[i];

         if (currentTank < 0) {
            startStation = i + 1;
                currentTank = 0;
            }
        }
        
        if(totalGas>=totalCost){
            return startStation;
        }
        return -1;
    }
}
