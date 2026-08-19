import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowToMask = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col == 1 || col == 10) continue;
            
            int mask = rowToMask.getOrDefault(row, 0);
            if (col == 2 || col == 3) mask |= 1;       
            else if (col == 4 || col == 5) mask |= 2;  
            else if (col == 6 || col == 7) mask |= 4; 
            else if (col == 8 || col == 9) mask |= 8;  
            
            rowToMask.put(row, mask);
        }
        int maxGroups = (n - rowToMask.size()) * 2;
        for (int mask : rowToMask.values()) {
            boolean left = (mask & 3) == 0;  
            boolean right = (mask & 12) == 0; 
            boolean middle = (mask & 6) == 0; 
            if (left && right) {
                maxGroups += 2;
            } else if (left || right || middle) 
            {
                maxGroups += 1;
            }
        }
        
        return maxGroups;
    }
}