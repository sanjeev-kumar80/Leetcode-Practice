
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();

        List<Integer> ll=new ArrayList<>();

        helper(root,0,targetSum,ll,ans);
        return ans;
    }
    private static void helper(TreeNode root,int sum,int target,List<Integer> ll,List<List<Integer>> ans){
        if(root==null) return ;
        ll.add(root.val);
        sum+=root.val;
        

        if((root.left==null && root.right==null)){
            if(sum==target){
                ans.add(new ArrayList<>(ll));
                
            }
            ll.remove(ll.size()-1);
                // sum-=root.val;
            return;
        }
        helper(root.left,sum,target,ll,ans);
        helper(root.right,sum,target,ll,ans);
        ll.remove(ll.size()-1);
    }
}