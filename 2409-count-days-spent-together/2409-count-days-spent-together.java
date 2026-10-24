class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceArrival = calculateDayOfYear(arriveAlice);
        int aliceLeaving = calculateDayOfYear(leaveAlice);
        int bobArrival = calculateDayOfYear(arriveBob);
        int bobLeaving = calculateDayOfYear(leaveBob);
        
        int latestArrival = Math.max(aliceArrival, bobArrival);
        int earliestLeaving = Math.min(aliceLeaving, bobLeaving);
        
        return Math.max(0, earliestLeaving - latestArrival + 1);
    }
    
    private int calculateDayOfYear(String date) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        
        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonths[i];
        }
        return dayOfYear;
    }
}