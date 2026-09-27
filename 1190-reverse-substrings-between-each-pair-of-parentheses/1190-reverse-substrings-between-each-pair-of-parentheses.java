class Solution {
    public String reverseParentheses(String s) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(sb.length());
            } else if (c == ')') {
                int start = stack.pop();
                StringBuilder sub = new StringBuilder(sb.substring(start));
                sub.reverse();
                sb.replace(start, sb.length(), sub.toString());
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}