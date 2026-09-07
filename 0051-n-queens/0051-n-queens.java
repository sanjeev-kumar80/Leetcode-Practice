class Solution {

    List<List<String>> ll=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        boolean [][] board=new boolean[n][n];
        sit(board,n,0);
        return ll;

        
        
    }

    public void sit(boolean [][] board ,int tq,int row){
        if(tq==0){
            ll.add(display(board));
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

    public List<String> display(boolean [][] board){
    List<String> temp = new ArrayList<>();

        for(int i = 0; i < board.length; i++){

            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < board.length; j++){

                if(board[i][j]) sb.append("Q");
                else sb.append(".");
            }

            temp.add(sb.toString());
        }

        return temp;
    }
}