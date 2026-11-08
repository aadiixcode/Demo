class Solution {
    int helper(int num, int[] dp) {
        if (num == 1 || num == 2) {
            return 1;
        }
        if (dp[num] != 0) {
            return dp[num];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < num; i++) {
            int a = i * (num - i);
            int b = i * helper(num - i, dp);
            max = Math.max(max, Math.max(a, b));
        }
        return dp[num] = max;
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        return helper(n, dp);
    }
}