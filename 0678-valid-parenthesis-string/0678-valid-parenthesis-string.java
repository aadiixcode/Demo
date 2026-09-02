class Solution {
    int helper(int index, int balance, String s, int[][] dp) {
        if (index == s.length()) {
            if (balance == 0) {
                return 1;
            }
            return 0;
        }
        if (balance < 0) {
            return 0;
        }

        if (dp[index][balance] != -1) {
            return dp[index][balance];
        }

        if (s.charAt(index) == '(') {
            if (helper(index + 1, balance + 1, s, dp) == 1) {
                return dp[index][balance] = 1;
            }
        } else if (s.charAt(index) == ')') {
            if (helper(index + 1, balance - 1, s, dp) == 1) {
                return dp[index][balance] = 1;
            }
        }

        else {
            if (helper(index + 1, balance + 1, s, dp) == 1) {
                return dp[index][balance] = 1;
            }
            if (helper(index + 1, balance - 1, s, dp) == 1) {
                return dp[index][balance] = 1;
            }
            if (helper(index + 1, balance, s, dp) == 1) {
                return dp[index][balance] = 1;
            }
        }
        return dp[index][balance] = 0;
    }

    public boolean checkValidString(String s) {
        int[][] dp = new int[s.length()][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(0, 0, s, dp) == 1 ? true : false;
    }
}