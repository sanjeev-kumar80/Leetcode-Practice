class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        int current = root.val + left + right;

        ans = Math.max(ans, current);

        return root.val + Math.max(left, right);
    }
}