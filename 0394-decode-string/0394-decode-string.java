class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.push(String.valueOf(ch));
            } else {
                StringBuilder substr = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    substr.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder k = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    k.insert(0, stack.pop());
                }
                int repeat = Integer.parseInt(k.toString());
                String repeated = substr.toString().repeat(repeat);
                stack.push(repeated);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String str : stack) {
            result.append(str);
        }
        return result.toString();
    }
}