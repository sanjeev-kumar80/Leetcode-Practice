
class Solution {
    public TreeNode invertTree(TreeNode root) {
        return helper(root);}

    public TreeNode helper(TreeNode root){
        if(root==null) return null;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        root.left=helper(root.left);
        root.right=helper(root.right);
        return root;
    }
}