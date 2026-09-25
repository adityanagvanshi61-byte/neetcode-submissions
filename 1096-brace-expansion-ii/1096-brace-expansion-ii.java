class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = new HashSet<>();
        int i = expression.indexOf('{');
        if (i == -1) {
            result.add(expression);
            List<String> sortedResult = new ArrayList<>(result);
            Collections.sort(sortedResult);
            return sortedResult;
        }
        
        int j = i, count = 0;
        for (; j < expression.length(); j++) {
            if (expression.charAt(j) == '{') count++;
            else if (expression.charAt(j) == '}') count--;
            if (count == 0) break;
        }
        
        String before = expression.substring(0, i);
        String middle = expression.substring(i + 1, j);
        String after = expression.substring(j + 1);
        
        List<String> parts = new ArrayList<>();
        int commaCount = 0;
        int start = 0;
        for (int k = 0; k < middle.length(); k++) {
            if (middle.charAt(k) == '{') commaCount++;
            else if (middle.charAt(k) == '}') commaCount--;
            else if (middle.charAt(k) == ',' && commaCount == 0) {
                parts.add(middle.substring(start, k));
                start = k + 1;
            }
        }
        parts.add(middle.substring(start));
        
        for (String part : parts) {
            List<String> subResult = braceExpansionII(before + part + after);
            result.addAll(subResult);
        }
        
        List<String> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult);
        return sortedResult;
    }
}