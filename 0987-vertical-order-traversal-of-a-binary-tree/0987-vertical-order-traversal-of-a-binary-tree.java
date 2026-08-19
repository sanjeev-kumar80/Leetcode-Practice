class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);
        
        // Sort by col, then row, then value
        Collections.sort(nodes, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1]; // col
            if (a[0] != b[0]) return a[0] - b[0]; // row
            return a[2] - b[2]; // value
        });
        
        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        for (int[] node : nodes) {
            if (node[1] != prevCol) {
                result.add(new ArrayList<>());
                prevCol = node[1];
            }
            result.get(result.size() - 1).add(node[2]);
        }
        return result;
    }
    
    private void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) return;
        nodes.add(new int[]{row, col, node.val});
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
}
