class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        // column -> list of (row, value)
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        dfs(root, 0, 0, map);

        for (List<int[]> list : map.values()) {

            // row ascending, then value ascending
            Collections.sort(list, (a, b) -> {
                if (a[0] != b[0])
                    return a[0] - b[0];

                return a[1] - b[1];
            });

            List<Integer> temp = new ArrayList<>();

            for (int[] p : list) {
                temp.add(p[1]);
            }

            ans.add(temp);
        }

        return ans;
    }

    public void dfs(TreeNode root, int row, int col,
                    TreeMap<Integer, List<int[]>> map) {

        if (root == null) return;

        map.putIfAbsent(col, new ArrayList<>());

        map.get(col).add(new int[]{row, root.val});

        dfs(root.left, row + 1, col - 1, map);
        dfs(root.right, row + 1, col + 1, map);
    }
}