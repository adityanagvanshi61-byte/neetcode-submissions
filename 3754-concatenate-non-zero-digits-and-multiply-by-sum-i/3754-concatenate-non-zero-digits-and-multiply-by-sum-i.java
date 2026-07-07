class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) return 0;
        
        long x = 0;
        long multiplier = 1;
        long sum = 0;
        
        int tempN = n;
        java.util.List<Integer> digits = new java.util.ArrayList<>();
        while (tempN > 0) {
            int digit = tempN % 10;
            if (digit != 0) {
                digits.add(digit);
                sum += digit;
            }
            tempN /= 10;
        }
        
       
        for (int i = 0; i < digits.size(); i++) {
            x += (long) digits.get(i) * multiplier;
            multiplier *= 10;
        }
        
        return x * sum;
    }
}