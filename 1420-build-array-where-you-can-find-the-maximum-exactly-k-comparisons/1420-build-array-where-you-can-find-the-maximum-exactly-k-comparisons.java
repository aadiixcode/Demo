class Solution {
    int m, k, n;
    int mod = 1000000007;

    int[][][] dp;

    int helper(int index, int cost, int max) {
        if (cost > k) {
            return 0;
        }
        if (index == n) {
            if (cost == k) {
                return 1;
            }
            return 0;
        }

        if (dp[index][cost][max + 1] != -1) {
            return dp[index][cost][max + 1];
        }

        long ways = 0;
        for (int val = 1; val <= m; val++) {
            if (val > max) {
                ways = (ways + helper(index + 1, cost + 1, val)) % mod;
            } else {
                ways = (ways + helper(index + 1, cost, max)) % mod;
            }
        }

        return dp[index][cost][max + 1] = (int) ways;
    }

    public int numOfArrays(int length, int range, int cost) {
        m = range;
        k = cost;
        n = length;

        dp = new int[n + 1][k + 1][m + 2];
        for (int a = 0; a < n + 1; a++) {
            for (int b = 0; b < k + 1; b++) {
                for (int c = 0; c < m + 2; c++) {
                    dp[a][b][c] = -1;
                }
            }
        }
        return helper(0, 0, -1);
    }
}