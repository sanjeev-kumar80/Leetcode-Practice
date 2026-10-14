class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int q=maximum_circular_sum(nums);
        return q;
        
    }
    public static int maximum_circular_sum(int [] arr){
        int linear_maximum_sum=kadanes_algo(arr);
        int total_sum=0;
        for(int i=0;i<arr.length;i++){
            total_sum+=arr[i];
            arr[i]=arr[i]*-1;
        }
        int circular_sum=total_sum+kadanes_algo(arr);
        if(circular_sum==0){
            return linear_maximum_sum;
        }
        return Math.max(linear_maximum_sum,circular_sum);
    }
    public static int kadanes_algo(int [] arr){
         int ans=Integer.MIN_VALUE;

        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            ans=Math.max(ans, sum);
            if(sum<0){
                sum=0;
            }
        }

        return ans;
    }
}