class Solution {
    int[][] dp;

    int helper(int i, int j, int m, int n) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (i < 0 || i == n || j < 0 || j == m) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int down = helper(i + 1, j, m, n);
        int right = helper(i, j + 1, m, n);
        return dp[i][j] = down + right;
    }

    public int uniquePaths(int n, int m) {
        dp = new int[n][m];
        return helper(0, 0, m, n);
    }
}