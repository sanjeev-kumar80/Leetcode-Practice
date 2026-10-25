class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row =row;
            this.col=col;
        }
    }
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;

        boolean [][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==false && grid[i][j]==0){
                    if(bfs(i,j,grid,vis)){
                        count++;
                    }
                }
            }
        };
        return count;
    }
    private boolean bfs(int i,int j,int [][] arr,boolean[][] vis){
        boolean flag=true;
        int n=arr.length;
        int m=arr[0].length;

        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(i,j));

        vis[i][j]=true;
        while(q.size()>0){
            Pair curr=q.remove();
            int row=curr.row;
            int col=curr.col;

            // here check the boundary
           if(row == 0 || row == n-1 || col == 0 || col == m-1) flag=false;

            int [] dr={-1,1,0,0};
            int [] dc={0,0,-1,1};

            for(int idx=0;idx<4;idx++){
                int nr=row+dr[idx];
                int nc=col+dc[idx];
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==false && arr[nr][nc]==0){
                    q.add(new Pair(nr,nc));
                    vis[nr][nc]=true;
                }
            }
           

        }
         return flag;

    }
}