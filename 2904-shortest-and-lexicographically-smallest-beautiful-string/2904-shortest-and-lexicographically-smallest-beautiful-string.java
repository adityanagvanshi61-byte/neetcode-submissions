class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int count = 0;
        String best = "";
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                count++;
            }
            while (count > k || (left <= right && count == k && s.charAt(left) == '0')) {
                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
            }
            if (count == k) {
                String current = s.substring(left, right + 1);
                if (current.length() < minLen) {
                    minLen = current.length();
                    best = current;
                } else if (current.length() == minLen) {
                    if (current.compareTo(best) < 0) {
                        best = current;
                    }
                }
            }
        }
        
        return best;
    }
}