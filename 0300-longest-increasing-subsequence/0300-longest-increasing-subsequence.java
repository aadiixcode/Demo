class Solution {
    int[][] dp;

    int helper(int[] arr, int index, int prevInd) {
        if (index >= arr.length) {
            return 0;
        }

        if (dp[index][prevInd + 1] != -1) {
            return dp[index][prevInd + 1];
        }

        int take = 0;
        if (prevInd == -1 || arr[index] > arr[prevInd]) {
            take = 1 + helper(arr, index + 1, index);
        }
        int nottake = helper(arr, index + 1, prevInd);
        return dp[index][prevInd + 1] = Math.max(take, nottake);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(nums, 0, -1);
    }
}