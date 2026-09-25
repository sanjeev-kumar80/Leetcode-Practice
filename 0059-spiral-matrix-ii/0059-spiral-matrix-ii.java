class Solution {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int start = 0, end = n - 1, num = 1;

        while (start <= end) {
            for (int i = start; i <= end; i++) {
                a[start][i] = num++;
            }

            for (int i = start + 1; i <= end; i++) {
                a[i][end] = num++;
            }

            for (int i = end - 1; i >= start; i--) {
                a[end][i] = num++;
            }

            for (int i = end - 1; i > start; i--) {
                a[i][start] = num++;
            }

            start++;
            end--;
        }

        return a;
    }
}
