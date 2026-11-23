class Solution {
    int[][] dp;

    int helper(int i, int j, int[][] arr, int m, int n) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (i < 0 || i == n || j < 0 || j == m) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (arr[i][j] == 1) {
            return 0;
        }

        int down = helper(i + 1, j, arr, m, n);
        int right = helper(i, j + 1, arr, m, n);
        return dp[i][j] = down + right;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        if (obstacleGrid[n - 1][m - 1] == 1) {
            return 0;
        }
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(0, 0, obstacleGrid, m, n);
    }
}