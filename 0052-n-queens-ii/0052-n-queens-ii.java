class Solution {

    static int count=0;
    public int totalNQueens(int n) {
         count = 0;
        boolean [][] board=new boolean[n][n];
        sit(board,n,0);
        return count;
    }

    public void sit(boolean [][] board ,int tq,int row){
        if(tq==0){
            count++;
            return;
        }

        for(int col=0;col<board[0].length;col++){

            if(issafe(board,row,col)){
                board[row][col]=true;

                sit(board,tq-1,row+1);
                board[row][col]=false;
            }
        }
    }

    public boolean issafe(boolean [][] board,int row,int col){
        int r=row;
        int c=col;

        while(r>=0){
            if(board[r][c]==true) return false;
            r--;
        }

        r=row;
        c=col;

        while(r>=0 && c>=0){
            if(board[r][c]==true) return false;
            r--;
            c--;
        }

        r=row;
        c=col;

        while(r>=0 && c<board[0].length){
            if(board[r][c]==true) return false;
            r--;
            c++;
        }
        return true;
    }

   
}