class Solution {
    public void helper(TreeNode root, List<TreeNode> ll) {
    if (root == null) return;

    ll.add(root);
    helper(root.left, ll);
    helper(root.right, ll);
}

public void flatten(TreeNode root) {
    if (root == null) return;

    List<TreeNode> ll = new ArrayList<>();
    helper(root, ll);

    for (int i = 1; i < ll.size(); i++) {
        ll.get(i - 1).left = null;
        ll.get(i - 1).right = ll.get(i);
    }
}
}