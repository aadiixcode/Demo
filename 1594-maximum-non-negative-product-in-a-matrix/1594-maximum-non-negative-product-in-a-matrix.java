class Solution {
    Pair[][] dp;

    static class Pair {
        long max, min;

        Pair(long max, long min) {
            this.max = max;
            this.min = min;
        }
    }

    Pair helper(int i, int j, int[][] grid) {

        if (i >= grid.length || j >= grid[0].length) {
            return null;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return new Pair(grid[i][j], grid[i][j]);
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        Pair right = helper(i, j + 1, grid);
        Pair down = helper(i + 1, j, grid);

        long val = grid[i][j];

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        if (right != null) {
            long a = right.max * val;
            long b = right.min * val;

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        if (down != null) {
            long a = down.max * val;
            long b = down.min * val;

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        return dp[i][j] = new Pair(maxVal, minVal);
    }

    public int maxProductPath(int[][] grid) {
        dp = new Pair[grid.length][grid[0].length];
        long ans = helper(0, 0, grid).max;

        if (ans < 0)
            return -1;

        return (int) (ans % 1000000007);
    }
}