class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n][m];
        long p = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = (int) p;
                p = (p * grid[i][j]) % 12345;
            }
        }

        long s = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                ans[i][j] = (int) ((s * ans[i][j]) % 12345);
                s = (s * grid[i][j]) % 12345;
            }
        }
        return ans;
    }
}