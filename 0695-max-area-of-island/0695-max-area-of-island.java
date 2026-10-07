class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean [][] vis=new boolean [n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && grid[i][j]==1){
                    int bfs=bfs(i,j,grid,vis);
                    max=Math.max(max,bfs);
                }
            }
        }
        return max;
    }

    private int bfs(int i,int j,int [][] arr,boolean [][] vis){
        int count=1;
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(i,j));
        vis[i][j]=true;

        while(q.size()>0){
            Pair curr=q.remove();
            int row=curr.row;
            int col=curr.col;

            int[] dr={-1,1,0,0};
            int [] dc={0,0,-1,1};

            for(int idx=0;idx<4;idx++){
                int nr=row+dr[idx];
                int nc=col+dc[idx];

                if(nr>=0 && nr< arr.length && nc>=0 && nc< arr[0].length && vis[nr][nc]==false && arr[nr][nc]==1){
                    q.add(new Pair(nr,nc));
                    count++;
                    vis[nr][nc]=true;
                }
            }
         }
         return count;


    }
}