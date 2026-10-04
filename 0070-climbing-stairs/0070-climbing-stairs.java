class Solution {
    static int [] dp ;
    public int climbStairs(int n) {
        dp=new int [n+1];
        dp[0]=1;
        dp[1]=1;
        return helper(n);
    }

    private static int helper(int n){
        if(n<0) return 0;
        if(n==0 || n==1) return 1;
        if(dp[n]!=0) return dp[n];
        int a=helper(n-1);
        int b=helper(n-2);
        return dp[n]= a+b;
    }
}