class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] grid) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();

        Queue<List<Integer>> q=new LinkedList<>();
        ll.add(0);
        q.add(ll);
        int target=grid.length-1;

        while(q.size()>0){
            List<Integer> currentPath = q.poll();

            
            int node = currentPath.size()>0?currentPath.get(currentPath.size() - 1):0;

            if (node == target) {
                ans.add(currentPath);
                continue;
            }

            for (int ele : grid[node]) {
                List<Integer> newPath = new ArrayList<>(currentPath);
                newPath.add(ele);
                q.offer(newPath);
            }
        }
        return ans;

    }

}

// class Solution {
//     public List<List<Integer>> allPathsSourceTarget(int[][] grid) {
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> path = new ArrayList<>();

//         int target = grid.length - 1;

//         dfs(0, target, grid, path, ans);

//         return ans;
//     }

//     void dfs(int node, int target, int[][] grid,
//              List<Integer> path, List<List<Integer>> ans) {

//         path.add(node);

//         if (node == target) {
//             ans.add(new ArrayList<>(path));
//             path.remove(path.size() - 1);
//             return;
//         }

//         for (int next : grid[node]) {
//             dfs(next, target, grid, path, ans);
//         }

//         path.remove(path.size() - 1);
//     }
// }
