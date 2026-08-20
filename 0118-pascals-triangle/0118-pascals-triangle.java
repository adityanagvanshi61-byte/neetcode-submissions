class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=1;i<=numRows;i++){
           ans.add(generateRows(i));
        }
        return ans;
    }
    public List<Integer> generateRows(int row){
        long ans=1;
        List<Integer> ansrows= new ArrayList<>();
            ansrows.add(1);
            for(int col=1;col<row;col++){
                ans= ans*(row-col);
                ans= ans/col;
                ansrows.add((int)ans);
            }
        
        return ansrows;
        
    }
}