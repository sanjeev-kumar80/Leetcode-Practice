
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{0, k});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int d = curr[0];
            int node = curr[1];

            for (int[] edge : adj.get(node)) {

                int nei = edge[0];
                int wt = edge[1];

                if (d + wt < dist[nei]) {
                    dist[nei] = d + wt;
                    pq.add(new int[]{dist[nei], nei});
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}

