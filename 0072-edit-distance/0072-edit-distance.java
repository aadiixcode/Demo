class Solution {
    int[][] dp;

    int helper(String s, String t, int i, int j) {
        if (i == s.length()) {
            return t.length() - j;
        }

        if (j == t.length()) {
            return s.length() - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            return helper(s, t, i + 1, j + 1);
        }

        int insert = 1 + helper(s, t, i, j + 1);
        int update = 1 + helper(s, t, i + 1, j + 1);
        int delete = 1 + helper(s, t, i + 1, j);

        return dp[i][j] = Math.min(insert, Math.min(update, delete));
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(word1, word2, 0, 0);
    }
}