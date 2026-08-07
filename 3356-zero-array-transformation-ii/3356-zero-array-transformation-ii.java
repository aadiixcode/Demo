class Solution {
    boolean allBecomesZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n];
        for (int i = 0; i <= k; i++) {
            int low = queries[i][0];
            int high = queries[i][1];
            int value = queries[i][2];
            diff[low] += value;
            if (high + 1 < n) {
                diff[high + 1] -= value;
            }
        }

        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > diff[i]) {
                return false;
            }
        }
        return true;
    }

    boolean isAlreadyZero(int[] nums) {
        for (int e : nums) {
            if (e != 0) {
                return false;
            }
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        if (isAlreadyZero(nums)) {
            return 0;
        }

        int ans = -1;
        int low = 0, high = queries.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean allZero = allBecomesZero(nums, queries, mid);
            if (allZero) {
                ans = mid + 1;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}