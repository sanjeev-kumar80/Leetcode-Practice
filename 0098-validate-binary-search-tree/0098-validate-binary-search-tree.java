class Solution {
    
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean check(TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }

        // Current node range ke bahar hai
        if (root.val <= min || root.val >= max) {
            return false;
        }

        // Left: range becomes (min, root.val)
        // Right: range becomes (root.val, max)
        return check(root.left, min, root.val) &&
               check(root.right, root.val, max);
    }
}