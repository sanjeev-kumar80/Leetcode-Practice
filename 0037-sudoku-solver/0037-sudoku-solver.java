class Solution {
    public void solveSudoku(char[][] board) {
        solve(board,0,0);

    }

    public boolean solve(char [][] board ,int row,int col){

        if(col==9) {
            col=0;
            row++;
        }
        if(row==9){
            return true;
        }

        if(board[row][col] != '.'){
            return solve(board,row,col+1);
        }

        for(char val = '1'; val <= '9'; val++){
            if(issafe(board,row,col,val)){
                board[row][col]=val;

                if(solve(board,row,col+1)){
                    return true;
                }

                board[row][col]='.';
            }
        }
        return false;
    } 


    public boolean issafe(char [][] board,int row,int col,char val){
        for(int c=0;c<9;c++){
            if(board[row][c]==val) return false;
        }

        for(int r=0;r<9;r++){
            if(board[r][col]==val) return false;
        }

        int sr = row - row%3;
        int sc = col - col%3;

        for(int r=sr;r<sr+3;r++){
            for(int c=sc;c<sc+3;c++){
                if(board[r][c]==val) return false;
            }
        }

        return true;
    }
}