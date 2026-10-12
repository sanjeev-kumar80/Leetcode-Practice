class Solution {
    
    public int maxProfit(int[] arr) {
        int n=arr.length;
        
        int[][][] dp=new int[n+1][2][3];

        
        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy==1){
                            dp[idx][buy][cap]= Math.max(-arr[idx]+dp[idx+1][0][cap],
                                                    0+dp[idx+1][1][cap]);
                        }
                        else{
                            dp[idx][buy][cap]= Math.max(arr[idx]+dp[idx+1][1][cap-1],
                                                    0+dp[idx+1][0][cap]);
                        }
                }
            }
        }
        return dp[0][1][2];
    }
        
}


// class Solution {
//     static int[][][] dp;
//     public int maxProfit(int[] prices) {
//         int n=prices.length;
//         dp=new int[n][2][3];
//         for(int[][] aa:dp){
//             for(int[]a:aa){
//                 Arrays.fill(a,-1);
//             }
//         }
//         return fun(0,1,2,prices);
//     }

//     private static int fun(int idx,int buy,int cap,int[] arr){
//         if(cap==0){
//             return 0;
//         }
        
//         if(idx==arr.length){
//             return 0;
//         }
//         if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
//         int profit=0;
//         if(buy==1){
//             profit= Math.max(-arr[idx]+fun(idx+1,0,cap,arr),
//                                     0+fun(idx+1,1,cap,arr));
//         }
//         else{
//             profit= Math.max(arr[idx]+fun(idx+1,1,cap-1,arr),
//                                     0+fun(idx+1,0,cap,arr));
//         }
//         return dp[idx][buy][cap]=profit;
//     }
// }

// normal recursion

// class Solution {
//     public int maxProfit(int[] prices) {
//         return fun(0,1,2,prices);
//     }

//     private static int fun(int idx,int buy,int cap,int[] arr){
//         if(cap==0){
//             return 0;
//         }
//         if(idx==arr.length){
//             return 0;
//         }
//         int profit=0;
//         if(buy==1){
//             profit= Math.max(-arr[idx]+fun(idx+1,0,cap,arr),
//                                     0+fun(idx+1,1,cap,arr));
//         }
//         else{
//             profit= Math.max(arr[idx]+fun(idx+1,1,cap-1,arr),
//                                     0+fun(idx+1,0,cap,arr));
//         }
//         return profit;
//     }
// }