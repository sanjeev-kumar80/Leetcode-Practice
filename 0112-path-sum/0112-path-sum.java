class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        return helper(root, targetSum, 0);
    }

    public boolean helper(TreeNode root, int targetSum, int sum) {
        if (root == null) return false;

        sum += root.val;

        if (targetSum == sum && root.left == null && root.right == null) {
            return true;
        }

        return helper(root.left, targetSum, sum) ||
               helper(root.right, targetSum, sum);
    }
}