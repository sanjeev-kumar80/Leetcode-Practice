class Solution {
    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null || (root.left == null && root.right == null)) return 0;
        int leftAns=diameterOfBinaryTree(root.left);
        int rightAns=diameterOfBinaryTree(root.right);

        int max=height(root.left)+height(root.right);
        if(root.left!=null) max++;
        if(root.right!=null) max++;

        max=Math.max(max,Math.max(leftAns,rightAns));
        return max;
    }

    public int height(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}