import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n];
        
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        k--; // Adjust k to 0-indexed
        StringBuilder sb = new StringBuilder();
        
        for (int i = n; i > 0; i--) {
            int index = k / factorial[i - 1];
            k %= factorial[i - 1];
            
            sb.append(numbers.get(index));
            numbers.remove(index);
        }
        
        return sb.toString();
    }
}