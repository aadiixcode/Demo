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

        int count = 0;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (i == j) {
                    dp[i][j] = 1;
                } else if (i + 1 == j) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 1 : 0;
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                    }
                }

                if (dp[i][j] == 1) {
                    count += 1;
                }
            }
        }
        return count;
    }
}