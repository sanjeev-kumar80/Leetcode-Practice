class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        solve(root, 0, map);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < map.size(); i++) {
            ans.add(map.get(i));
        }

        return ans;
    }

    public void solve(TreeNode root, int level,
                      HashMap<Integer, List<Integer>> map) {

        if (root == null)
            return;

        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }

        map.get(level).add(root.val);

        solve(root.left, level + 1, map);
        solve(root.right, level + 1, map);
    }
}