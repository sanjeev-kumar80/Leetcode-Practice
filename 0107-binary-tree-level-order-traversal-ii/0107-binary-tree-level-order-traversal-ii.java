class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        helper(root, ans);
        return ans;
    }

    public void helper(TreeNode root, List<List<Integer>> ans) {

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        List<Integer> ll = new ArrayList<>();

        while (!q.isEmpty()) {

            TreeNode temp = q.poll();

            if (temp == null) {

                ans.add(0, ll);
                ll = new ArrayList<>();

                if (!q.isEmpty())
                    q.add(null);

            } else {

                ll.add(temp.val);

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }
        }
    }
}