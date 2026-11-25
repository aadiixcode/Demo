class Solution {
    int helper(int i, int j, int n, int[][] dp, List<List<Integer>> arr) {
        if (i >= n || i < 0 || j >= n || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (i == n - 1) {
            return arr.get(i).get(j);
        }

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int leftDiag = helper(i + 1, j, n, dp, arr);
        int rightDiag = helper(i + 1, j + 1, n, dp, arr);

        return dp[i][j] = arr.get(i).get(j) + Math.min(leftDiag, rightDiag);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            Arrays.fill(dp[j], Integer.MAX_VALUE);
        }
        return helper(0, 0, n, dp, triangle);
    }
}