class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && vis[i][j] == false) {
                    count++;
                    bfs(i, j, grid, vis);
                }
            }
        }

        return count;
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] vis) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new ArrayDeque<>();

        q.add(new Pair(i, j));
        vis[i][j] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (q.size() > 0) {

            Pair curr = q.remove();

            int row = curr.row;
            int col = curr.col;

            for (int idx = 0; idx < 4; idx++) {

                int newrow = row + dr[idx];
                int newcol = col + dc[idx];

                if (newrow >= 0 && newrow < n &&
                    newcol >= 0 && newcol < m &&
                    grid[newrow][newcol] == '1' &&
                    vis[newrow][newcol] == false) {

                    q.add(new Pair(newrow, newcol));
                    vis[newrow][newcol] = true;
                }
            }
        }
    }
}