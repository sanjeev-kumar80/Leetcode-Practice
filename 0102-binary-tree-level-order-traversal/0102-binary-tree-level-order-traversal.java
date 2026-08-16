class Solution {

    public void bfs(TreeNode root, List<List<Integer>> ll) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                l.add(temp.val);

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            ll.add(l);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ll = new ArrayList<>();
        bfs(root, ll);
        return ll;
    }
}