class Solution {
    public int[] twoSum(int[] numbers, int target) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n=numbers.length;
        int[] res= new int[2];
        int i=0;
        int j=n-1;
        while(i<=j){
            if(numbers[i]+numbers[j]==target){
                arr.add(i);
                arr.add(j);
                res[0]=i+1;
                res[1]=j+1;
                return res;
            }
            else if(numbers[i]+numbers[j]>target){
                j--;
            }
            else{
                i++;
            }
        }
        return res;
    }
}