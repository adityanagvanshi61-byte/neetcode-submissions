class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        // Helper to check if string is sorted
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        
        // Length 2 case cannot be sorted if not already sorted
        if (n == 2) return -1;
        
        char minChar = s.charAt(0), maxChar = s.charAt(0);
        for (int i = 0; i < n; i++) {
            minChar = (char) Math.min(minChar, s.charAt(i));
            maxChar = (char) Math.max(maxChar, s.charAt(i));
        }
        
        // Check if minChar is at the beginning or maxChar is at the end
        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1;
        }
        
        // Check conditions for 3 operations vs 2 operations
        boolean hasMinInProperPrefix = false;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == minChar) {
                hasMinInProperPrefix = true;
                break;
            }
        }
        
        boolean hasMaxInProperSuffix = false;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == maxChar) {
                hasMaxInProperSuffix = true;
                break;
            }
        }
        
        if (!hasMinInProperPrefix && !hasMaxInProperSuffix) {
            return 3;
        }
        
        return 2;
    }
}