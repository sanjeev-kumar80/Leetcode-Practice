class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
       if(root==null ) return false; 
       return helper(root,targetSum);
    }

    public boolean helper(TreeNode root,int targetSum){
        if(root==null) return false;

        if(root.val==targetSum && (root.left==null && root.right==null)) return true;
        return helper(root.left,targetSum-root.val)||helper(root.right,targetSum-root.val);
    }
}