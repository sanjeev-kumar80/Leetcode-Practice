class Solution {
    static int[] dp;
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int ele:nums){
            max=Math.max(max,ele);
        }
        int[] arr=new int [max+1];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]=arr[nums[i]]+nums[i];
        }
        dp=new int[arr.length+1];

        Arrays.fill(dp,-1);

        return helper(0,arr);
    }
    private int helper(int idx,int [] arr){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int take=helper(idx+2,arr)+arr[idx];
        int no=helper(idx+1,arr);
        return dp[idx]=Math.max(take,no);
    }
}
