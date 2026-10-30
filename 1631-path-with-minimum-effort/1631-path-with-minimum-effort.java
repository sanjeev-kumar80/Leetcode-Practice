class Solution {
    class Pair{
        int row;
        int col;
        int dis;
        Pair(int row,int col,int dis){
            this.row=row;
            this.col=col;
            this.dis=dis;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        
        int n=heights.length;
        int m=heights[0].length;
        int [][] ans=new int [n][m];
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.dis, b.dis));

        for(int [] a:ans){
            Arrays.fill(a,Integer.MAX_VALUE);
        }

        q.add(new Pair(0,0,0));
        ans[0][0]=0;

        while(q.size()>0){
            Pair curr=q.poll();
            int row=curr.row;
            int col=curr.col;
            int val=curr.dis;

            if (row == n- 1 && col == m - 1) {
                return val;
            }

            if(ans[row][col]<val) continue;

            int [] dr={-1,0,1,0};
            int [] dc={0,1,0,-1};

            for(int i=0;i<dr.length;i++){
                int newrow=row+dr[i];
                int newcol=col+dc[i];

                if(newrow>-1 && newrow<n && newcol>-1 && newcol<m){
                    int newval=Math.abs(heights[row][col]-heights[newrow][newcol]);
                    newval=Math.max(val,newval);
                    if(newval<ans[newrow][newcol]){
                        ans[newrow][newcol]=newval;
                        q.add(new Pair(newrow,newcol,newval));
                    }
                }
            }
        }
        return  0;
    }
}