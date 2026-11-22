class Solution {
    int[][] dp;

    int check(String s, int i, int j) {
        if (i > j) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = check(s, i + 1, j - 1);
        }
        return dp[i][j] = 0;
    }

    public int countSubstrings(String s) {
        int n = s.length();
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(s, i, j) == 1) {
                    count += 1;
                }
            }
        }
        return count;
    }
}