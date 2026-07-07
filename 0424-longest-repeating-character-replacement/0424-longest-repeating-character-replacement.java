class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int maxLen = 0;
        int maxFreq = 0;
        Map<Character, Integer> countMap = new HashMap<>();

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            countMap.put(currentChar, countMap.getOrDefault(currentChar, 0) + 1);
            maxFreq = Math.max(maxFreq, countMap.get(currentChar));
            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                countMap.put(leftChar, countMap.get(leftChar) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}