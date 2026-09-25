class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        // return helper(0,0,m,n);

        // return solve(0,0,m,n,dp);
        return solve(dp);
    }
    private int solve(int [][] dp){
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=1;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    private int solve(int row,int col,int m,int n,int[][] dp){
        if(row>m-1 || col>n-1){
            return 0;
        }
        if(row==m-1 &&  col==n-1) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        int rightway=solve(row,col+1,m,n,dp);
        int leftway=solve(row+1,col,m,n,dp);

        dp[row][col]=rightway+leftway;
        return dp[row][col];
    }


    private int helper(int row,int col,int m,int n){
        // using recursion
        if(row>m-1 || col>n-1) return 0;

        if(row==m-1 && col==n-1) return 1;

        int rightway=helper(row,col+1,m,n);
        int leftway=helper(row+1,col,m,n);

        return rightway+leftway;
    }
}