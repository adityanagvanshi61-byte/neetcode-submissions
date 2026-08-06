class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean left = true;
        int remaining = n;

        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head += step;
            }

            remaining /= 2;
            step *= 2;
            left = !left;
        }

        return head;
    }
}