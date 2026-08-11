class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int row =0;row<9;row++){
            for(int cl=0;cl<9;cl++){
                if(board[row][cl]=='.'){
                    for(int digits=1;digits<=9;digits++){
                        if(isValid(board,row,cl,digits)){
                            board[row][cl] = (char)(digits + '0');
                                if (solve(board)==true){
                                    return true;
                                }
                                board[row][cl]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board,int row,int cl,int digits){
        for(int i=0;i<=8;i++){
           if(board[row][i] == (char)(digits + '0')){
                return false;
            }
            if(board[i][cl] == (char)(digits + '0')){
                return false;
            }
            int boxrow=3*(row/3)+(i/3);
            int boxcol=3*(cl/3)+(i%3);
           if (board[boxrow][boxcol] == (char)(digits + '0')) {
            return false;
            }
        }
        return true;
    }
    
}