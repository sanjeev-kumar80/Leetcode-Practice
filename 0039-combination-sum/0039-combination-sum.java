class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();

        helper(0,ll,ans,candidates,target);
        return ans;
    }

    private void helper(int idx,List<Integer>ll,List<List<Integer>> ans,int [] arr,int target){
        if(idx==arr.length){
            return ;
        }
        if(target <0) return ;

        if(target==0) {
            ans.add(new ArrayList<>(ll));
            return;
        }

          // TAKE
        ll.add(arr[idx]);

        // Same element dobara le sakte hain
        helper(idx, ll,ans,arr,target-arr[idx]);

        // UNDO
        ll.remove(ll.size() - 1);

        // NOT TAKE
        helper(idx + 1, ll,ans,arr,target);

    }
}