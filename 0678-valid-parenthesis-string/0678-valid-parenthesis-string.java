class Solution {
    boolean helper(int index, int balance, String s, int[][] dp) {
        if (index == s.length()) {
            if (balance == 0) {
                return true;
            }
            return false;
        }
        if (balance < 0) {
            return false;
        }

        if (dp[index][balance] != -1) {
            return dp[index][balance] == 1 ? true : false;
        }

        boolean isValid = false;
        if (s.charAt(index) == '(') {
            isValid |= helper(index + 1, balance + 1, s, dp);
        } else if (s.charAt(index) == ')') {
            isValid |= helper(index + 1, balance - 1, s, dp);
        } else {
            isValid |= helper(index + 1, balance - 1, s, dp);
            isValid |= helper(index + 1, balance, s, dp);
            isValid |= helper(index + 1, balance + 1, s, dp);
        }
        if (isValid) {
            dp[index][balance] = 1;
            return true;
        }
        dp[index][balance] = 0;
        return false;
    }

    public boolean checkValidString(String s) {
        int[][] dp = new int[s.length()][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(0, 0, s, dp);
    }
}