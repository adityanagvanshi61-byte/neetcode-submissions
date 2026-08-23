class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = arr[i]; // value
            a[i][1] = i;      // original index
        }

        Arrays.sort(a, (x, y) -> x[0] - y[0]);

        int i = 0, j = n - 1;

        while (i < j) {
            int sum = a[i][0] + a[j][0];

            if (sum == target)
                return new int[]{a[i][1], a[j][1]};
            else if (sum < target)
                i++;
            else
                j--;
        }

        return new int[]{-1, -1};
    }
}