class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        int[] count = new int[maxVal + 1];
        for (int num : nums) {
            count[num]++;
        }
        long[] exactGcdCount = new long[maxVal + 1];
        for (int i = maxVal; i >= 1; i--) {
            long multipleCount = 0;
            for (int j = i; j <= maxVal; j += i) {
                multipleCount += count[j];
            }
            long pairs = multipleCount * (multipleCount - 1) / 2;
            for (int j = 2 * i; j <= maxVal; j += i) {
                pairs -= exactGcdCount[j];
            }
            
            exactGcdCount[i] = pairs;
        }
        long[] prefixSum = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSum[i] = prefixSum[i - 1] + exactGcdCount[i];
        }
        int[] answer = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            long q = queries[k];
            
            int left = 1;
            int right = maxVal;
            int res = maxVal;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (prefixSum[mid] > q) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1; 
                }
            }
            answer[k] = res;
        }

        return answer;
    }
}