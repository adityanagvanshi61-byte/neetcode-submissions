class Solution {
    public boolean checkDivisibility(int n) {
        int original = n;
        int sum = 0;
        int mul = 1;

        while (n != 0) {
            int digit = n % 10;

            sum = sum + digit;
            mul = mul * digit;

            n = n / 10;
        }

        int total = sum + mul;

        if (original % total == 0)
            return true;
        else
            return false;
    }
}