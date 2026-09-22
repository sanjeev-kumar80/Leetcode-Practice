class Solution {
    public int calculateMinimumHP(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;

        int [][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        // return helper(0,0,arr);
        return solve(0,0,arr,dp);
    }

    private int solve(int row,int col,int[][] dungeon,int[][] dp){
        int m = dungeon.length;
        int n = dungeon[0].length;

        // Out of bounds
        if (row >= m || col >= n) {
            return Integer.MAX_VALUE;
        }

        // Destination
        if (row == m - 1 && col == n - 1) {
            return Math.max(1, 1 - dungeon[row][col]);
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int right = solve(row, col + 1, dungeon,dp);
        int down = solve(row + 1, col, dungeon,dp);

        int next = Math.min(right, down);

        return dp[row][col]= Math.max(1, next - dungeon[row][col]);
    }
     private int helper(int row, int col, int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        // Out of bounds
        if (row >= m || col >= n) {
            return Integer.MAX_VALUE;
        }

        // Destination
        if (row == m - 1 && col == n - 1) {
            return Math.max(1, 1 - dungeon[row][col]);
        }

        int right = helper(row, col + 1, dungeon);
        int down = helper(row + 1, col, dungeon);

        int next = Math.min(right, down);

        return Math.max(1, next - dungeon[row][col]);
    }
}