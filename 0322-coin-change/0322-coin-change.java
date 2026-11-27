class Solution {
    public int coinChange(int[] arr, int amount) {
        
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int ans=solve(arr,amount ,dp);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
       
        // if(sum<amount) return -1;

        // List<Integer> ll=new ArrayList<>();
        // List<List<Integer>> ans=new ArrayList<>();
        // com(0,arr,amount,ll,ans);
        // if (ans.isEmpty()) {
        //     return -1;
        // }

        // int size = Integer.MAX_VALUE;

        // for (List<Integer> ele : ans) {
        //     size = Math.min(size, ele.size());
        // }

        // return size;

    }
   
    private int solve(int[] coins,int amount,int []dp){
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return Integer.MAX_VALUE;
        }
        if(dp[amount
        ]!=-1){
            return dp[amount];
        }
        int min=Integer.MAX_VALUE;

        for(int i=0;i<coins.length;i++){
            int res=solve(coins,amount-coins[i],dp);

            if(res!=Integer.MAX_VALUE){
                min=Math.min(min,res+1);
            }
        }

        dp[amount]=min;
        return min;
    }
    private void com(int idx,int [] arr,int target,List<Integer> ll,List<List<Integer>> ans){
        if(idx==arr.length){
            return;
        }
        if(target<0){
            return ;
        }
        if(target==0){
            ans.add(new ArrayList<>(ll));
            return ;
        }

        ll.add(arr[idx]);

        com(idx,arr,target-arr[idx],ll,ans);

        ll.remove(ll.size()-1);

        com(idx+1,arr,target,ll,ans);
    }
}
