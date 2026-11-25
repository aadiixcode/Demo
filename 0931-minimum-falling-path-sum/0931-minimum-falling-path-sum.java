class Solution {
    int helper(int i, int j, int n, int[][] dp, int[][] arr) {
        if (i >= n || i < 0 || j >= n || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (i == n - 1) {
            return arr[i][j];
        }

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int leftDiag = helper(i + 1, j - 1, n, dp, arr);
        int down = helper(i + 1, j, n, dp, arr);
        int rightDiag = helper(i + 1, j + 1, n, dp, arr);

        return dp[i][j] = arr[i][j] + Math.min(leftDiag, Math.min(down, rightDiag));
    }

    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            Arrays.fill(dp[j], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, helper(0, i, n, dp, matrix));
        }
        return ans;
    }
}