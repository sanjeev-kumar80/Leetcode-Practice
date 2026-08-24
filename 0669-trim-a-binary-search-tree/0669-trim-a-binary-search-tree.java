class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null) {
            return null;
        }

        // Root too small
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        // Root too large
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // Root is valid
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}