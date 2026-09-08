class Solution { 
    public boolean isValidSudoku(char[][] board) { 

        for(int i = 0; i < 9; i++) { 
            for(int j = 0; j < 9; j++) { 

                if(board[i][j] == '.') {
                    continue;
                }

                boolean search = issafe(board, i, j, board[i][j]); 

                if(search == false) { 
                    return false; 
                } 
            } 
        } 

        return true; 
    } 
 
    public boolean issafe(char[][] board, int row, int col, char val) { 

        // Row
        for(int c = 0; c < 9; c++) { 
            if(board[row][c] == val && c != col) {
                return false; 
            }
        } 
 
        // Column
        for(int r = 0; r < 9; r++) { 
            if(board[r][col] == val && r != row) {
                return false; 
            }
        } 

        int sr = row - row % 3; 
        int sc = col - col % 3; 
 
        for(int r = sr; r < sr + 3; r++) { 
            for(int c = sc; c < sc + 3; c++) { 

                if(board[r][c] == val && (r != row && c != col)) {
                    return false; 
                }
            } 
        } 
 
        return true; 
    } 
}