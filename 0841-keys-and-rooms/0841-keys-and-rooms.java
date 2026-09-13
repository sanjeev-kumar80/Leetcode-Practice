class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        
        int n=adj.size();
        boolean [] vis=new boolean [n];

        bfs(0,vis,adj);

        for(boolean bol:vis){
            if(bol==false) return false;
        }
        return true;
    }

    private void bfs(int start ,boolean [] vis,List<List<Integer>> adj){
        Queue<Integer> q=new LinkedList<>();

        q.add(start);
        vis[start]=true;

        while(q.size()>0){
            int front=q.remove();
            for(int ele:adj.get(front)){
                if(!vis[ele]){
                     q.add(ele);
                    vis[ele]=true;
                }
            }
        }
    }
}