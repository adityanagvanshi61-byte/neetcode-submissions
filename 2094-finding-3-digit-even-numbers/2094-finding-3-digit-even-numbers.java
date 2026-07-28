import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits);
        List<Integer> resultList = new ArrayList<>();
        boolean[] visited = new boolean[digits.length];
        backtrack(digits, 0, 0, visited, resultList);
        return resultList.stream().mapToInt(i -> i).toArray();
    }
    
    private void backtrack(int[] digits, int currentNumber, int depth, boolean[] visited, List<Integer> resultList) {
        if (depth == 3) {
            if (currentNumber % 2 == 0) {
                resultList.add(currentNumber);
            }
            return;
        }
        
        for (int i = 0; i < digits.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && digits[i] == digits[i - 1] && !visited[i - 1]) continue;
            if (depth == 0 && digits[i] == 0) continue;
            
            visited[i] = true;
            int nextNumber = currentNumber * 10 + digits[i];
            backtrack(digits, nextNumber, depth + 1, visited, resultList);
            visited[i] = false;
        }
    }
}