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


