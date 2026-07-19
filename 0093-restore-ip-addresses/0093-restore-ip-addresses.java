class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        backtrack(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void backtrack(List<String> res, List<String> current, String s, int index) {
        if (current.size() == 4) {
            if (index == s.length()) {
                res.add(String.join(".", current));
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) break;
            
            String part = s.substring(index, index + i);
            
            if ((part.startsWith("0") && part.length() > 1) || Integer.parseInt(part) > 255) {
                continue;
            }
            
            current.add(part);
            backtrack(res, current, s, index + i);
            current.remove(current.size() - 1);
        }
    }
}