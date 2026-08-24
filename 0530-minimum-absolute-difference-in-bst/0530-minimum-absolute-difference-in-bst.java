class Solution {

    int prev = -1;
    int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return ans;
    }

    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        // Left
        inorder(root.left);

        // Current
        if (prev != -1) {
            ans = Math.min(ans, root.val - prev);
        }

        prev = root.val;

        // Right
        inorder(root.right);
    }
}