class Solution {
    int[][] dp;

    int helper(int i, int j, int n, int m, int[][] arr) {
        if (i == n - 1 && j == m - 1) {
            if (arr[i][j] <= 0) {
                return Math.abs(arr[i][j]) + 1;
            }
            return 1;
        }

        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int right = helper(i, j + 1, n, m, arr);
        int down = helper(i + 1, j, n, m, arr);

        int req = Math.min(right, down);

        int val = req - arr[i][j];

        return dp[i][j] = val <= 0 ? 1 : val;
    }

    public int calculateMinimumHP(int[][] dungeon) {
        dp = new int[dungeon.length][dungeon[0].length];
        return helper(0, 0, dungeon.length, dungeon[0].length, dungeon);
    }
}