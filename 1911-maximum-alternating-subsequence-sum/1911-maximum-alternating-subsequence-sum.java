class Solution {
    long[][] dp;

    long helper(int[] arr, int index, int positive) {
        if (index >= arr.length) {
            return 0;
        }

        if (dp[index][positive] != Long.MIN_VALUE) {
            return dp[index][positive];
        }

        long take;
        if (positive == 1) {
            take = arr[index] + helper(arr, index + 1, 0);
        } else {
            take = -arr[index] + helper(arr, index + 1, 1);
        }
        long nottake = helper(arr, index + 1, positive);

        return dp[index][positive] = Math.max(take, nottake);
    }

    public long maxAlternatingSum(int[] nums) {
        dp = new long[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], Long.MIN_VALUE);
        }

        helper(nums, 0, 1);
        return Math.max(dp[0][0], dp[0][1]);
    }
}