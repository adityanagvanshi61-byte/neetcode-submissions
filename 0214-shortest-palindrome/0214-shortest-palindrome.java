class Solution {
    public String shortestPalindrome(String s) {
        if(s==null|| s.length()<=1){
            return s;
        }
        String rev_s= new StringBuilder(s).reverse().toString();
        String temp= s + "#" + rev_s;
        int[] table=new int[temp.length()];
        for(int i=1;i<temp.length();i++){
            int j=table[i-1];
            while(j>0 && temp.charAt(i) != temp.charAt(j)){
                j=table[j-1];
            }
            if(temp.charAt(i) == temp.charAt(j)){
                j++;
            }
            table[i] = j;
        }
        return rev_s.substring(0,s.length() - table[temp.length()-1]) +s;
    }
}