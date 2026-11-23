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

    public String longestPalindrome(String s) {

        int n = s.length();
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int maxLen = 0, startInd = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(s, i, j) == 1 && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    startInd = i;
                }
            }
        }
        return s.substring(startInd, startInd + maxLen);
    }
}