class Solution {

    class Pair {
        int first;
        int secound;

        Pair(int first, int secound) {
            this.first = first;
            this.secound = secound;
        }
    }

    public int orangesRotting(int[][] grid) {

        int count = 0;
        int ans = 0;

        Queue<Pair> q = new LinkedList<>();

        // Add all rotten oranges
        // Count fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }

                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        // BFS
        while (!q.isEmpty() && count > 0) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Pair p = q.poll();

                int row = p.first;
                int col = p.secound;

                // Right
                if (col + 1 < grid[0].length &&
                    grid[row][col + 1] == 1) {

                    grid[row][col + 1] = 2;
                    q.add(new Pair(row, col + 1));
                    count--;
                }

                // Left
                if (col - 1 >= 0 &&
                    grid[row][col - 1] == 1) {

                    grid[row][col - 1] = 2;
                    q.add(new Pair(row, col - 1));
                    count--;
                }

                // Up
                if (row - 1 >= 0 &&
                    grid[row - 1][col] == 1) {

                    grid[row - 1][col] = 2;
                    q.add(new Pair(row - 1, col));
                    count--;
                }

                // Down
                if (row + 1 < grid.length &&
                    grid[row + 1][col] == 1) {

                    grid[row + 1][col] = 2;
                    q.add(new Pair(row + 1, col));
                    count--;
                }
            }

            ans++;
        }

        if (count == 0) {
            return ans;
        }

        return -1;
    }
}