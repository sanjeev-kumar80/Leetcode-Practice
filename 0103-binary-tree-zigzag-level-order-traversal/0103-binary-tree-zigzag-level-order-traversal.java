class Solution {

    public static void bfs(TreeNode root, List<List<Integer>> ans) {
        int h = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> ll = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.remove();

                ll.add(temp.val);

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }

            if (h % 2 == 0) {
                ans.add(ll);
            } else {
                Collections.reverse(ll);
                ans.add(ll);
            }

            h++;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        bfs(root, ans);

        return ans;
    }
}