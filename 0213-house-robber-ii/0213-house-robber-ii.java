class Solution {
    public int rob(int[] nums) {
        
        int n=nums.length-1;
        if(n==0) return nums[0];
        int [] dp=new int [nums.length+1];
        Arrays.fill(dp,-1);

        int a=solve(0,n-1,nums,dp);
        Arrays.fill(dp,-1);
        int b=solve(1,n,nums,dp);

        return Math.max(a,b);
        
    }
    private int solve(int start,int end,int [] arr,int[] dp){
        if(start>end){
            return 0;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        int a=solve(start+2,end,arr,dp)+arr[start];
        int b=solve(start+1,end,arr,dp);
        return dp[start]=Math.max(a,b);
    }
}