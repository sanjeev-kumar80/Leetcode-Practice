class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        color_fun(image,sr,sc,color);
        return image;
    }

    private void color_fun(int [][] arr,int i,int j,int color){
        int a=arr[i][j];

        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(i,j));
        arr[i][j]=color;

        while(q.size()>0){
            Pair curr=q.remove();
            int row=curr.row;
            int col=curr.col;

            int [] dr={-1,1,0,0};
            int [] dc={0,0,-1,1};

            for(int idx=0;idx<4;idx++){
                int nr=row+dr[idx];
                int nc=col+dc[idx];
                if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length && arr[nr][nc]==a){
                    arr[nr][nc]=color;
                    q.add(new Pair(nr,nc));
                }
            }
        }

    }
}