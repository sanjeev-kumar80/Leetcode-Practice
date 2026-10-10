class Pair{
    int node;
    int dis;
    Pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int wt=times[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int[] des=new int[n+1];
        Arrays.fill(des,Integer.MAX_VALUE);
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.dis-b.dis);

        q.add(new Pair(k,0));
        des[k]=0;
        while(q.size()>0){
            Pair curr=q.poll();
            int node=curr.node;
            int dis=curr.dis;

            if(des[node]<dis) continue;

            for(Pair ele:adj.get(node)){
                int newdes=dis+ele.dis;
                if(newdes<des[ele.node]){
                    des[ele.node]=newdes;
                    q.add(new Pair(ele.node,newdes));
                }
            }
        }

int ans=0;
        for(int i=1;i<=n;i++){
            if(des[i]==Integer.MAX_VALUE) return -1;
            ans=Math.max(ans,des[i]);
        }
        return ans;
    }
}