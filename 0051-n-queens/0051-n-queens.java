import java.util.*;

class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        print(board, n, 0);
        return ans;
    }

    public void print(boolean[][] board, int tq, int row){

        if(tq == 0){
            ans.add(Display(board));
            return;
        }

        for(int col = 0; col < board[0].length; col++){

            if(issafe(board, col, row)){

                board[row][col] = true;

                print(board, tq - 1, row + 1);

                board[row][col] = false; // backtracking
            }
        }
    }

    public boolean issafe(boolean[][] board, int col, int row){

        // right diagonal
        int r = row;
        int c = col;
        while(r >= 0 && c < board.length){
            if(board[r][c]) return false;
            r--;
            c++;
        }

        // left diagonal
        r = row;
        c = col;
        while(r >= 0 && c >= 0){
            if(board[r][c]) return false;
            r--;
            c--;
        }

        // vertical up
        r = row;
        c = col;
        while(r >= 0){
            if(board[r][c]) return false;
            r--;
        }

        return true;
    }

    public List<String> Display(boolean[][] board){

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