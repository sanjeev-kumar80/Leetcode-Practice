class Solution {
    TreeNode first=null;
    TreeNode secound=null;
    TreeNode prev=null;
    public void recoverTree(TreeNode root) {
        inorder(root);

       // Swap values
        int temp = first.val;
        first.val = secound.val;
        secound.val = temp;
        
    }

    public void inorder(TreeNode root){
        if(root==null) return;

        inorder(root.left);

        if(prev!=null && prev.val>root.val){
            if(first==null) {
                first=prev;
            }
            secound=root;
        }
        prev=root;
        inorder(root.right);
    }
}