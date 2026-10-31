class Solution {
    int numberOfPartitions(int[] nums, int maxSum) {
        int count = 1, sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] > maxSum) {
                count += 1;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return count;
    }

    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int e : nums) {
            low = Math.max(low,e);
            high += e;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int partitionCount = numberOfPartitions(nums, mid);

            if (partitionCount > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}