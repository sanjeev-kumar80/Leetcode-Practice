class Solution {
    static int [][][] dp;
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        dp=new int[n][2][k+1];
         for(int[][] aa:dp){
            for(int[]a:aa){
                Arrays.fill(a,-1);
            }
        }
        return fun(0,1,k,prices);
    }

     private static int fun(int idx,int buy,int cap,int[] arr){
        if(cap==0){
            return 0;
        }
        
        if(idx==arr.length){
            return 0;
        }
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
        int profit=0;
        if(buy==1){
            profit= Math.max(-arr[idx]+fun(idx+1,0,cap,arr),
                                    0+fun(idx+1,1,cap,arr));
        }
        else{
            profit= Math.max(arr[idx]+fun(idx+1,1,cap-1,arr),
                                    0+fun(idx+1,0,cap,arr));
        }
        return dp[idx][buy][cap]=profit;
    }
}