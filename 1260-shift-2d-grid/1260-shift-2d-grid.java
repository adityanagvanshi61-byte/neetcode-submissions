import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int totalElements = m * n;
        k = k % totalElements;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                result.get(i).add(0);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int originalIndex = i * n + j;
                int newIndex = (originalIndex + k) % totalElements;
                
                int newRow = newIndex / n;
                int newCol = newIndex % n;
                
                result.get(newRow).set(newCol, grid[i][j]);
            }
        }
        
        return result;
    }
}