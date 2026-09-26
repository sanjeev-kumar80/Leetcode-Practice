class Solution {
    public int minQueenMoves(int[] s, int[] t) {
        int r=s[0]-1;
        int c=s[1]-1;
        int tr=t[0]-1;
        int tc=t[1]-1;

        if(r==tr && c==tc) return 0;

        boolean [] [] vis=new boolean [8][8];
        int[][] q=new int [64][3];

        int f=0,b=0;
        q[b++]=new int []{r,c,0};
        vis[r][c]=true;
        int [] dr={1,-1,0,0,1,1,-1,-1};
        int [] dc={0,0,1,-1,1,-1,1,-1        };

        while(f<b){
            int x=q[f][0];
            int y=q[f][1];
            int d=q[f][2];
            f++;
            for(int k=0;k<8;k++){
                int nx=x+dr[k];
                int ny=y+dc[k];

                while(nx>=0 && nx<8 && ny>=0 && ny<8){
                    if(nx==tr && ny==tc){
                        return d+1;
                    }
                    if(!vis[nx][ny]){
                        vis[nx][ny]=true;
                        q[b++]=new int []{nx,ny,d+1};
                    }
                    nx+=dr[k];
                    ny+=dc[k];
                }
            }
        }
        return -1;
    }
}