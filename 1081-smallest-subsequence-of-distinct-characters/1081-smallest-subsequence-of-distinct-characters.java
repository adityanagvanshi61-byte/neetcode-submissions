class Solution {
    public String smallestSubsequence(String s) {
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        java.util.Stack<Character> stack = new java.util.Stack<>();
        boolean[] seen = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (seen[curr - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && curr < stack.peek() && i < lastOccurrence[stack.peek() - 'a']) {
                char removed = stack.pop();
                seen[removed - 'a'] = false;
            }
            stack.push(curr);
            seen[curr - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}