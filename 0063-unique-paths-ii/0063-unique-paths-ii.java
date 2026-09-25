class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;

        if(arr[0][0]==1 || arr[m-1][n-1]==1){
            return 0;
        }

        int[][] dp=new int[m][n];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        // return helper(0,0,m,n,arr);

        return solve(0,0,m,n,arr,dp);

    }

    private int solve(int row,int col,int m,int n,int[][] arr,int [][]dp){
        if(row>m-1 || col>n-1){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        if(row==m-1 && col==n-1){
            return 1;
        }
        if(arr[row][col]==1){
            return 0;

        }
        
        int rightway=solve (row,col+1,m,n,arr,dp);
        int downway=solve(row+1,col,m, n,arr,dp);
        dp[row][col]=rightway+downway;

        return dp[row][col];
    }

    private int helper(int row,int col,int m,int n,int[][]arr){
        if(row>m-1 || col>n-1){
            return 0;
        }
        if(row==m-1 && col==n-1){
            return 1;
        }
        if(arr[row][col]==1){
            return 0;

        }
        
        int rightway=helper(row,col+1,m,n,arr);
        int downway=helper(row+1,col,m, n,arr);

        return rightway+downway;
    }
}