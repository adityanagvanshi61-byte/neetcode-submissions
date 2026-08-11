class Solution {
    private Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                String leftExpr = expression.substring(0, i);
                String rightExpr = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(leftExpr);
                List<Integer> rightResults = diffWaysToCompute(rightExpr);

                for (int l : leftResults) {
                    for (int r : rightResults) {
                        if (c == '+') {
                            results.add(l + r);
                        } else if (c == '-') {
                            results.add(l - r);
                        } else if (c == '*') {
                            results.add(l * r);
                        }
                    }
                }
            }
        }

        if (results.isEmpty()) {
            results.add(Integer.parseInt(expression));
        }

        memo.put(expression, results);
        return results;
    }
}