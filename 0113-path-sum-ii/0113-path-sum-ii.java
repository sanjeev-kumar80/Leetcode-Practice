class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();

        List<Integer> ll=new ArrayList<>();

        helper(root,ans,ll,targetSum,0);

        return ans;
    }

    public void helper(TreeNode root,List<List<Integer>> ans,List<Integer> ll,int targetSum,int sum){

        if(root==null) return ;

        // Add current node
        ll.add(root.val);
        sum += root.val;

        // Leaf node
        if (root.left == null && root.right == null) {

            if (sum == targetSum) {
                ans.add(new ArrayList<>(ll));
            }

            // Backtracking
            ll.remove(ll.size() - 1);
            return;
        }

        helper(root.left,ans,ll,targetSum,sum);
        helper(root.right,ans,ll,targetSum,sum);
        ll.remove(ll.size()-1);
    }
}