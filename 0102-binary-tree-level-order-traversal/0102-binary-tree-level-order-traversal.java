class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            map.put(level, new ArrayList<>());

            for (int i = 0; i < size; i++) {

                TreeNode temp = q.poll();

                map.get(level).add(temp.val);

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }

            level++;
        }

        for (int i = 0; i < level; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }
}