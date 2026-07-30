class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int pushes=0;
        for(int i=0; i<n; i++){
            int multiplier=(i/8) +1;
            pushes += multiplier;
        }
        return pushes;
    }
}