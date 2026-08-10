class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return height(root);
    }

    public int height(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null) {
            return 1 + height(root.right);
        }

        if (root.right == null) {
            return 1 + height(root.left);
        }

        return 1 + Math.min(height(root.left), height(root.right));
    }
}