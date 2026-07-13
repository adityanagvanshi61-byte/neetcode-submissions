class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result= new ArrayList<>();
        String sample="123456789";
        for(int length=2;length<=9;length++){
           for (int startIndex = 0; startIndex <= 9 - length; startIndex++) {
            String substring = sample.substring(startIndex, startIndex + length);
             int num = Integer.parseInt(substring);

             if(num >= low && num<= high){
                result.add(num);
             }
           }
        }
        return result;
    }
}