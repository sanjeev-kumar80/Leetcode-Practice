class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0; long sum = 0; int left = 0; int right = 0;
        HashSet<Integer> sumSet = new HashSet<>();

        for(right=0; right<nums.length; right++){
            while(sumSet.contains(nums[right])){
                sum -= nums[left];
                sumSet.remove(nums[left]);
                left++;
            }

            sumSet.add(nums[right]);
            sum += nums[right];

            if(right-left+1 > k){
                sum -= nums[left];
                sumSet.remove(nums[left]);
                left++;
            }

            if(right-left+1 == k){
                maxSum = Math.max(maxSum, sum);
            }
        }
        
            return maxSum;
    }
}